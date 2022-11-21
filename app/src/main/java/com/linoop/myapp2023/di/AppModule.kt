package com.linoop.myapp2023.di

import android.content.Context
import androidx.room.Room
import com.linoop.myapp2023.storage.MyDao
import com.linoop.myapp2023.storage.MyDatabase
import com.linoop.myapp2023.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MyDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMyDao(myDatabase: MyDatabase) = myDatabase.getMyDao()
}


