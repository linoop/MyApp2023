package com.linoop.myapp2023.viewmodels

import androidx.lifecycle.ViewModel
import com.linoop.myapp2023.models.DefaultResponse
import com.linoop.myapp2023.models.MyData
import com.linoop.myapp2023.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val myRepo: MyRepo): ViewModel() {

    private val _response = MutableStateFlow(DefaultResponse())
    val response:Flow<DefaultResponse> = _response

}