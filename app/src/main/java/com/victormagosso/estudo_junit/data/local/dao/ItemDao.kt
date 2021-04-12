package com.victormagosso.estudo_junit.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.victormagosso.estudo_junit.data.local.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun observeAllItems(): LiveData<List<Item>>

    @Query("SELECT * FROM item WHERE id = :selectedId")
    fun getItemById(selectedId: Int): Item

    @Delete
    suspend fun deleteItem(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistItem(item: Item)
}