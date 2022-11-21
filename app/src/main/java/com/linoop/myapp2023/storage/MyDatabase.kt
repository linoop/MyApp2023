package com.linoop.myapp2023.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.linoop.myapp2023.models.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun getMyDao() : MyDao
}