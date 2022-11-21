package com.linoop.myapp2023.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.linoop.myapp2023.utils.Constants.ITEM_TABLE

@Entity(tableName = ITEM_TABLE)
data class ItemModel(
    @ColumnInfo(name = "item_code")
    var code: String = "",
    @ColumnInfo(name = "item_name")
    var name: String = "",
    @ColumnInfo(name = "price")
    var price: Double = 0.0,
    @ColumnInfo(name = "status")
    var status: Boolean = true,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    var id: Int? = null
}
