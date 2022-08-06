package com.example.networkboundresource.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.networkboundresource.Models.Restaurant


@Database(entities = [Restaurant::class] , version = 1)
abstract class RestaurantDataBase :RoomDatabase() {
    abstract fun RestaurantDao(): RestaurantDao
}