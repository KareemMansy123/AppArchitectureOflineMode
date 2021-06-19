package com.example.apparchitecturenetwork.network

import com.example.apparchitecturenetwork.models.RestaurantModel
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<RestaurantModel>
}