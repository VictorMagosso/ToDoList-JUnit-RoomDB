package com.victormagosso.estudo_junit.data.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.victormagosso.estudo_junit.data.local.dao.ItemDao
import com.victormagosso.estudo_junit.data.local.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemRoomDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}