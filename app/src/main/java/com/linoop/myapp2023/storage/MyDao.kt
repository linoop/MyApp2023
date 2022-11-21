package com.linoop.myapp2023.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.linoop.myapp2023.models.ItemModel

@Dao
interface MyDao {
    @Insert
    suspend fun insertItem(itemModel: ItemModel): Long

    @Insert
    suspend fun insertAllItem(items: List<ItemModel>)

    @Delete
    suspend fun deleteItem(itemModel: ItemModel)

    @Update
    suspend fun updateItem(itemModel: ItemModel)
}