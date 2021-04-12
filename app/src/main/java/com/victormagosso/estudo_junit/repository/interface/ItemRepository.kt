package com.victormagosso.estudo_junit.repository.`interface`

import androidx.lifecycle.LiveData
import com.victormagosso.estudo_junit.data.local.Item

interface ItemRepository {
    fun observeAllItems(): LiveData<List<Item>>

    fun getItemById(selectedId: Int): Item

    suspend fun deleteItem(item: Item)

    suspend fun persistItem(item: Item)
}