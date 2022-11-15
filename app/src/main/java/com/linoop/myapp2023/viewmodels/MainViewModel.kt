package com.linoop.myapp2023.viewmodels

import com.linoop.myapp2023.models.DefaultResponse
import com.linoop.myapp2023.models.MyData
import com.linoop.myapp2023.repository.MyRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class MainViewModel @Inject constructor(private val myRepo: MyRepo) {

    private val _response = MutableStateFlow(DefaultResponse())
    val response:Flow<DefaultResponse> = _response

    fun downloadData(){
        _response.value = myRepo.downloadData()
    }

    fun uploadData(data: MyData){
        _response.value = myRepo.uploadData(data)
    }
}