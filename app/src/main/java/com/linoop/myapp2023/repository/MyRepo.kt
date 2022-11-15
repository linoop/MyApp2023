package com.linoop.myapp2023.repository

import com.linoop.myapp2023.models.MyData
import com.linoop.myapp2023.network.Api
import javax.inject.Inject

class MyRepo @Inject constructor(private val api: Api) {
    fun downloadData() = api.downloadData()


    fun uploadData(myData: MyData) = api.uploadData(myData)
}