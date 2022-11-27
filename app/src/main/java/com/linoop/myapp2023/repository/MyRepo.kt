package com.linoop.myapp2023.repository

import com.linoop.myapp2023.models.LoginResponse
import com.linoop.myapp2023.models.SignUpResponse
import com.linoop.myapp2023.models.UserModel
import com.linoop.myapp2023.network.Api
import com.linoop.myapp2023.storage.SharedPrefManager
import com.linoop.myapp2023.utils.FieldValidator
import javax.inject.Inject

class MyRepo @Inject constructor(
    private val api: Api,
    private val sharedPrefManager: SharedPrefManager
) {


    suspend fun signUp(userData: UserModel): SignUpResponse? {
        if (!FieldValidator.validateName(userData.name)) return SignUpResponse(
            false,
            "Name field required"
        )
        else if (!FieldValidator.validateUsername(userData.username)) return SignUpResponse(
            false,
            "Username field required"
        )
        else if (!FieldValidator.validateEmail(userData.email)) return SignUpResponse(
            false,
            "Email field required"
        )
        else if (!FieldValidator.validatePassword(userData.password)) return SignUpResponse(
            false,
            "Password field required"
        )
        else userData.run {
            api.signUp(
                username = username, first_name = name, password = password,
                email = email, last_name = name
            )
        }.let {
            return if (it.isSuccessful) {
                it.body()
            } else SignUpResponse(false, it.message())
        }
    }

    suspend fun login(username: String, password: String): LoginResponse? {
        if (!FieldValidator.validateEmail(username)) return LoginResponse(
            status = false, message = "Please Enter a Valid Email"
        )
        if (!FieldValidator.validatePassword(username)) return LoginResponse(
            status = false, message = "Please Enter a Valid Password"
        )
        api.login(username, password).let {
            return if (it.isSuccessful) {
                sharedPrefManager.setUserId(username)
                sharedPrefManager.setToken(it.body()?.token ?: "")
                it.body()
            } else LoginResponse(status = false, message = "Login Failed")
        }
    }


}