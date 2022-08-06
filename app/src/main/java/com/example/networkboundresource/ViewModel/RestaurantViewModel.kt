package com.example.networkboundresource.ViewModel

import androidx.lifecycle.*
import com.example.networkboundresource.Api.RestaurantApi
import com.example.networkboundresource.DataBase.RestaurantRepository
import com.example.networkboundresource.Models.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(repository: RestaurantRepository):ViewModel() {
    val result = repository.getRestaurants().asLiveData()
}