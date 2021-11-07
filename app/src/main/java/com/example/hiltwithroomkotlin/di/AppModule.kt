package com.example.hiltwithroomkotlin.di

import android.content.Context
import com.example.hiltwithroomkotlin.db.AppDao
import com.example.hiltwithroomkotlin.db.AppDataBase
import com.example.hiltwithroomkotlin.network.RetroServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    val BASEURL = "https://api.github.com/search"


    @Provides
    @Singleton
    fun getDataBase(context: Context):AppDataBase{
        return AppDataBase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDataBaseDao(appDataBase: AppDataBase):AppDao{
        return appDataBase.getAppDao()
    }



    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit):RetroServiceInterface{
       return  retrofit.create(RetroServiceInterface::class.java)

    }

    @Provides
    @Singleton
    fun getRetroInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}