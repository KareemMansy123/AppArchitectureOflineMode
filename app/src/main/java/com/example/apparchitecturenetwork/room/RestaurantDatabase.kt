package com.example.apparchitecturenetwork.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apparchitecturenetwork.dao.RestaurantDao
import com.example.apparchitecturenetwork.models.RestaurantModel

@Database(entities = [RestaurantModel::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}