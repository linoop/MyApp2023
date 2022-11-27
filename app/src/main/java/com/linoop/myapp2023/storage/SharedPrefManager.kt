package com.linoop.myapp2023.storage

import android.content.SharedPreferences
import androidx.core.content.edit
import com.linoop.myapp2023.utils.Constants.BASE_URL
import javax.inject.Inject

class SharedPrefManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setBaseUrl(baseUrl: String) = sharedPreferences.edit { putString(BASE_URL, baseUrl) }
    fun getBaseUrl() = sharedPreferences.getString(BASE_URL, "http://lesparkle.in/")

    fun setToken(token: String) = sharedPreferences.edit { putString("token", token) }
    fun getToken() = sharedPreferences.getString("token", "")

    fun setUserId(baseUrl: String) = sharedPreferences.edit { putString("user_id", baseUrl) }
    fun getUserId() = sharedPreferences.getString("user_id", "")








}