package com.victormagosso.estudo_junit.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String = "",
    val description: String = "",
    val date: String = ""
)
