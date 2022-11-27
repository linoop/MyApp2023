package com.linoop.myapp2023.repository

import com.linoop.myapp2023.models.MyData
import com.linoop.myapp2023.network.Api
import com.linoop.myapp2023.storage.MyDao
import javax.inject.Inject

class MyRepo @Inject constructor(private val myDao: MyDao) {

}