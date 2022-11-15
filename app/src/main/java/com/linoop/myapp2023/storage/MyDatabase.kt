package com.linoop.myapp2023.storage

import android.util.Log
import com.linoop.myapp2023.models.Item
import com.linoop.myapp2023.utils.Constants.TAG

class MyDatabase {
    lateinit var name:String
    var version: Int = 0
    fun saveRecord(item: Item){
        Log.d(TAG, "Record saved successfully... ${item.name}")
    }
}