package com.linoop.myapp2023.viewmodels

import androidx.lifecycle.*
import com.linoop.myapp2023.models.UserModel
import com.linoop.myapp2023.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val myRepo: MyRepo) : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun signup(userModel: UserModel) = liveData {
        _isLoading.value = true
        myRepo.signUp(userModel).let {
            _isLoading.value = false
            emit(it)
        }
    }

    fun login(username:String,password:String) = liveData {
        _isLoading.value = true
        myRepo.login(username,password).let {
            _isLoading.value = false
            emit(it)
        }
    }


    fun setBaseUrl(url:String) = myRepo.setBaseUrl(url)
    fun getBaseUrl() :String = myRepo.getBaseUrl()


}