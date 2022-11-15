package com.linoop.myapp2023.di

import com.linoop.myapp2023.network.MyRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @RetrofitFirstServer
    @Provides
    fun provideRetrofitFirstServer() : MyRetrofit = MyRetrofit(connection = "First server")

    @RetrofitSecondServer
    @Provides
    fun provideRetrofitSecondServer(): MyRetrofit = MyRetrofit(connection = "Second server")

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitFirstServer

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitSecondServer