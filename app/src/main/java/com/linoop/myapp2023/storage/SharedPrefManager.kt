package com.linoop.myapp2023.storage

import android.content.SharedPreferences
import androidx.core.content.edit
import com.linoop.myapp2023.utils.Constants.BASE_URL
import javax.inject.Inject

class MyPreferenceImpl (private val sharedPreferences: SharedPreferences): MyPreference {
    override fun setBaseUrl(baseUrl: String) = sharedPreferences.edit { putString(BASE_URL, baseUrl) }
    override fun getBaseUrl() = sharedPreferences.getString(BASE_URL, "http://lesparkle.in/")

    override fun setToken(token: String) = sharedPreferences.edit { putString("token", token)  }
    override fun getToken() = sharedPreferences.getString("token", "")

    override fun setUserId(baseUrl: String) = sharedPreferences.edit { putString("user_id", baseUrl) }
    override fun getUserId() = sharedPreferences.getString("user_id", "")
}

interface MyPreference {
    fun setBaseUrl(baseUrl: String)
    fun getBaseUrl(): String?

    fun setToken(token: String)
    fun getToken(): String?

    fun setUserId(baseUrl: String)
    fun getUserId(): String?
}