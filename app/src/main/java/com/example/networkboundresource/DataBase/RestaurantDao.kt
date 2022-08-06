package com.example.networkboundresource.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.networkboundresource.Models.Restaurant
import kotlinx.coroutines.flow.Flow


@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertRestarant(restaurant: Restaurant)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertRestarants(restaurant: List<Restaurant>)

    @Query("SELECT * FROM RestaurantTable ORDER BY uid")
    fun getAllRestaurant(): Flow<List<Restaurant>>


    @Query("DELETE FROM RestaurantTable")
    suspend fun DeleteAll();
}