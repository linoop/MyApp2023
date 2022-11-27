package com.linoop.myapp2023.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.linoop.myapp2023.utils.Constants.ITEM_TABLE

@Entity(tableName = ITEM_TABLE)
data class UserModel(
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "username")
    var username: String = "",
    @ColumnInfo(name = "password")
    var password: String = "",
    @ColumnInfo(name = "email")
    var email: String = "",
    var lastName:String=""

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    var id: Int? = null
}
