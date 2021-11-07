package com.example.hiltwithroomkotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hiltwithroomkotlin.model.RepositoryData

@Dao
interface AppDao {

    @Query("SELECT * FROM repositories")
    fun getAllRecords():LiveData<List<RepositoryData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(repositoryData: RepositoryData)

    @Query("DELETE FROM repositories")
    fun deleteAllRecords()
}