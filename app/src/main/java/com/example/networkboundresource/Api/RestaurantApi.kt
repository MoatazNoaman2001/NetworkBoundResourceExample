package com.example.networkboundresource.Api

import com.example.networkboundresource.Models.Data
import com.example.networkboundresource.Models.Restaurant
import retrofit2.http.GET

interface RestaurantApi  {

    companion object{
        val base_url: String = "https://foodbukka.herokuapp.com/api/v1/"
    }

    @GET("restaurant")
    suspend fun getData(): Data
}