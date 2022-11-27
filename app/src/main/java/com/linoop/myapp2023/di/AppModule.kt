package com.linoop.myapp2023.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.linoop.myapp2023.network.Api
import com.linoop.myapp2023.storage.MyDatabase
import com.linoop.myapp2023.storage.SharedPrefManager
import com.linoop.myapp2023.storage.UrlInterceptor
import com.linoop.myapp2023.utils.Constants.BASE_URL
import com.linoop.myapp2023.utils.Constants.DATABASE_NAME
import com.linoop.myapp2023.utils.Constants.MY_PREF
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, MyDatabase::class.java, DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Api =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
            .create(Api::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            //.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Singleton
    @Provides
    fun provideUrlInterceptor(sharedPrefManager: SharedPrefManager): Interceptor =
        UrlInterceptor(sharedPrefManager)


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context): SharedPreferences =
        app.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideSharedPrefManager(sharedPreferences: SharedPreferences) =
        SharedPrefManager(sharedPreferences)


}
