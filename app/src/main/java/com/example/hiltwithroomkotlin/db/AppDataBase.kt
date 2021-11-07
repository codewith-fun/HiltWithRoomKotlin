package com.example.hiltwithroomkotlin.db

import android.content.Context
import androidx.room.*
import com.example.hiltwithroomkotlin.model.RepositoryData
import com.example.hiltwithroomkotlin.model.TypeConvertorOwner

@Database(entities = [RepositoryData::class],version = 1,exportSchema = false)
@TypeConverters(TypeConvertorOwner::class)
 abstract class AppDataBase :RoomDatabase(){
    abstract fun getAppDao(): AppDao

     companion object{
         private var INSTANCE :AppDataBase? = null

         fun getAppDBInstance(context: Context):AppDataBase{
             if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext
                    ,AppDataBase::class.java,"AppDb")
                        .allowMainThreadQueries()
                        .build()
             }
                 return INSTANCE!!
         }
     }
}