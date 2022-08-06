package com.example.networkboundresource.DataBase

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.room.withTransaction
import com.example.networkboundresource.Api.RestaurantApi
import com.example.networkboundresource.Models.Restaurant
import com.example.networkboundresource.Utils.networkBoundResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDataBase
) {
    private val dao: RestaurantDao = db.RestaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            dao.getAllRestaurant()
        },
        fetch = {
            api.getData().restaurants
        },
        saveFetchResult = {
            db.withTransaction {
                dao.DeleteAll()
                dao.InsertRestarants(it)
            }
        }
    )
}