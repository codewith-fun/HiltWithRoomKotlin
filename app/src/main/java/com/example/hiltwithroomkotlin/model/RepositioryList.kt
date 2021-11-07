package com.example.hiltwithroomkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

data class RepositioryList(val items:List<RepositoryData>)

@Entity(tableName = "repositories")
data class RepositoryData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int =0,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name:String?,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description:String?,
    @ColumnInfo(name = "owner")
    @SerializedName("owner")
    val owner:Owner?)


data class Owner(val avatar_url:String?)

    class TypeConvertorOwner {
        val gson: Gson = Gson()

        @TypeConverter
        fun stringToSomeObjectList(data: String?): Owner? {
            if (data == null) return null
            val listType: Type = object : TypeToken<Owner?>() {}.type
            return gson.fromJson<Owner?>(data, listType)
        }

        @TypeConverter
        fun objectToString(someObject: Owner?): String? {
            return gson.toJson(someObject)
        }
    }
