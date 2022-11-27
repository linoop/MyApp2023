package com.linoop.myapp2023.storage

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class UrlInterceptor(private val preferences: SharedPrefManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
       preferences.getBaseUrl()?.let { baseUrl ->
           val newUrl = HttpUrl.parse(
              chain.request().url().toString().replace("http://localhost/", baseUrl)
         ) ?: chain.request().url()
           request.url(newUrl)
           Log.d("MSD",baseUrl)
       }

        request.header("Accept", "application/json")
        Log.d("MSD_TOKEN",preferences.getToken().toString())
        request.header("Authorization", "Bearer ${preferences.getToken()}")
        return chain.proceed(request.build())
    }


}