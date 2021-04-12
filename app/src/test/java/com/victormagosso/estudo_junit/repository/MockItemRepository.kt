package com.victormagosso.estudo_junit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.victormagosso.estudo_junit.data.local.Item
import com.victormagosso.estudo_junit.repository.`interface`.ItemRepository

class MockItemRepository : ItemRepository{

    private val observableItems = MutableLiveData<List<Item>>()

    private fun refreshLiveData() {

    }
    
    override fun observeAllItems(): LiveData<List<Item>> {
        return observableItems
    }

    override fun getItemById(selectedId: Int): Item {
        val item = Item()
        return item
    }

    override suspend fun deleteItem(item: Item) {
        
    }

    override suspend fun persistItem(item: Item) {
        
    }
}