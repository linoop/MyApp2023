package com.linoop.myapp2023.network

import com.linoop.myapp2023.models.DefaultResponse
import com.linoop.myapp2023.models.MyData

interface Api {
    fun downloadData(): DefaultResponse
    fun uploadData(myData: MyData): DefaultResponse
}