package com.victormagosso.estudo_junit.repository

import androidx.lifecycle.LiveData
import com.victormagosso.estudo_junit.data.local.Item
import com.victormagosso.estudo_junit.data.local.dao.ItemDao
import com.victormagosso.estudo_junit.repository.`interface`.ItemRepository
import javax.inject.Inject

class ItemRepository @Inject constructor(val itemDao: ItemDao):ItemRepository {
    override fun observeAllItems(): LiveData<List<Item>> {
        return itemDao.observeAllItems()
    }

    override fun getItemById(selectedId: Int): Item {
        return itemDao.getItemById(selectedId)
    }

    override suspend fun deleteItem(item: Item) {
        return deleteItem(item)
    }

    override suspend fun persistItem(item: Item) {
        return itemDao.persistItem(item)
    }
}