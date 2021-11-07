package com.example.hiltwithroomkotlin.network

import androidx.lifecycle.LiveData
import com.example.hiltwithroomkotlin.db.AppDao
import com.example.hiltwithroomkotlin.model.RepositioryList
import com.example.hiltwithroomkotlin.model.RepositoryData
import retrofit.Call
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit
import javax.inject.Inject

class RetroRepositories @Inject constructor(
    private val retroServiceInterface: RetroServiceInterface,
    private val appDao: AppDao
) {

    fun getAllRecords(): LiveData<List<RepositoryData>> {
        return appDao.getAllRecords()
    }

    fun insertRecords(repositoryData: RepositoryData){
        appDao.insertRecords(repositoryData)
    }

    /**
     * get the data from github API
     */

    fun makeApiCall(query:String?){
        val call :Call<RepositioryList> = retroServiceInterface.getDataFromApi(query!!)
        call?.enqueue(object : Callback<RepositioryList>{
            override fun onResponse(response: Response<RepositioryList>?, retrofit: Retrofit?) {
                TODO("Not yet implemented")
                if (response!!.isSuccess){
                    appDao.deleteAllRecords()
                    response.body()?.items?.forEach {
                        insertRecords(it)
                    }
                }
            }

            override fun onFailure(t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}