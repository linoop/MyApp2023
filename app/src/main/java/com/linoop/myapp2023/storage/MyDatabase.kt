package com.linoop.myapp2023.storage


import androidx.room.Database
import androidx.room.RoomDatabase
import com.linoop.myapp2023.models.UserModel

@Database(
    entities = [UserModel::class],
    version = 5,
    exportSchema = true
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getDataDao(): MyDao


}