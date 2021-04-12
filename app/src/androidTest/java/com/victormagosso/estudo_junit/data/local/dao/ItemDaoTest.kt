package com.victormagosso.estudo_junit.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.victormagosso.estudo_junit.data.local.Item
import com.victormagosso.estudo_junit.data.local.roomdb.ItemRoomDatabase
import com.victormagosso.estudo_junit.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ItemDaoTest {

    //teste executor rule faz com que os metodos assincronos (runBlockingtest) sejam executados um após o outro (sincrono)
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: ItemRoomDatabase
    private lateinit var dao: ItemDao

    @Before
    fun setup() {
        //in memory = banco dedos na memoria , e nao persistir de verdade
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ItemRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = db.itemDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun insertItem() = runBlockingTest {
        val item = Item(id = 1, "Primeiro item", "descricao do primeiro item", Calendar.DATE.toString())
        dao.persistItem(item)

        val allItems = dao.observeAllItems().getOrAwaitValue()

        assertThat(allItems).contains(item)
    }

    @Test
    fun deleteItem() = runBlockingTest {
        val item = Item(id = 1, "Primeiro item", "desc", Calendar.DATE.toString())
        dao.persistItem(item)
        dao.deleteItem(item)

        val allItems = dao.observeAllItems().getOrAwaitValue()

        assertThat(allItems).isEmpty()
    }

    @Test
    fun getItemById() = runBlockingTest{
        val item = Item(id = 1, "Priemrio item", "desc", Calendar.DATE.toString())
        dao.persistItem(item)
        val selectedItem: Item = dao.getItemById(1)

        assertThat(selectedItem).isNotNull()
    }

    @Test
    fun observeAllItems() = runBlockingTest {
        val item1 = Item(1, "Primeiro", "desc1", Calendar.DATE.toString())
        val item2 = Item(2, "Segundo", "desc2", Calendar.DATE.toString())
        val item3 = Item(3, "Terceiro", "desc3", Calendar.DATE.toString())

        dao.persistItem(item1)
        dao.persistItem(item2)
        dao.persistItem(item3)

        val allItems = dao.observeAllItems().getOrAwaitValue()

        assertThat(allItems).hasSize(3)
    }
}