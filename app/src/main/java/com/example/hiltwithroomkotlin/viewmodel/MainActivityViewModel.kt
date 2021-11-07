package com.example.hiltwithroomkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hiltwithroomkotlin.model.RepositioryList
import com.example.hiltwithroomkotlin.model.RepositoryData
import com.example.hiltwithroomkotlin.network.RetroRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val retroRepositories: RetroRepositories) :ViewModel() {

    fun getAllRepositoriesList(): LiveData<List<RepositoryData>> {
        return retroRepositories.getAllRecords()
    }

    fun makeApiCall(){
        retroRepositories.makeApiCall("ny")
    }

    fun makeApiCallWithQuery(query:String?){
        retroRepositories.makeApiCall(query)
    }
}