package com.example.apparchitecturenetwork.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.apparchitecturenetwork.repo.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()

}