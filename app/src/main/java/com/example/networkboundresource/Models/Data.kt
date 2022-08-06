package com.example.networkboundresource.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Data(
    @SerializedName("Total Restaurants") val count: Int,
    @SerializedName("Result") val restaurants: List<Restaurant>
) : Serializable {
}