package com.example.hiltwithroomkotlin.network

import com.example.hiltwithroomkotlin.model.RepositioryList
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Query

interface RetroServiceInterface {

    @GET("repositories")
    fun getDataFromApi(@Query("q")query: String):Call<RepositioryList>
}