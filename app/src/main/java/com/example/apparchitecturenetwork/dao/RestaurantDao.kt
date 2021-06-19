package com.example.apparchitecturenetwork.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apparchitecturenetwork.models.RestaurantModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurants")
    fun getAllRestaurants(): Flow<List<RestaurantModel>>

    //OnConflictStrategy this config for if oldItem != newItem in adapter will replace in room
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurants: List<RestaurantModel>)

    @Query("DELETE FROM restaurants")
    suspend fun deleteAllRestaurants()
}