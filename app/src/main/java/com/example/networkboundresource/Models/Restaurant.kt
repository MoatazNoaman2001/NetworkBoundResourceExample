package com.example.networkboundresource.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "RestaurantTable")
data class Restaurant(
    @SerializedName("id") @PrimaryKey val uid: String,
    @SerializedName("businessname") val name: String,
    @SerializedName("restauranttype") val type: String,
    @SerializedName("address") val address: String,
    @SerializedName("reviews") val rate: String,
    @SerializedName("image") val logo:String
) : Serializable {
}