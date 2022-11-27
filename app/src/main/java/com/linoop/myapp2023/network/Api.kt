package com.linoop.myapp2023.network

import com.linoop.myapp2023.models.LoginResponse
import com.linoop.myapp2023.models.SignUpResponse
import com.linoop.myapp2023.utils.Constants.LOGIN_END_POINT
import com.linoop.myapp2023.utils.Constants.SIGN_UP_END_POINT
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST(SIGN_UP_END_POINT)
    suspend fun signUp(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String
    ): Response<SignUpResponse>


    @FormUrlEncoded
    @POST(LOGIN_END_POINT)
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<LoginResponse>
}