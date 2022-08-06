package com.example.networkboundresource.DI

import android.app.Application
import androidx.room.Room
import com.example.networkboundresource.Api.RestaurantApi
import com.example.networkboundresource.DataBase.RestaurantDataBase
import com.example.networkboundresource.Models.Restaurant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitBuilder {

    @Provides
    @Singleton
    fun ProviderRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(RestaurantApi.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun RestaurantProvider(retrofit: Retrofit): RestaurantApi =
        retrofit.create(RestaurantApi::class.java)

    @Provides
    @Singleton
    fun DataBaseProvider(app: Application) : RestaurantDataBase =
        Room.databaseBuilder(app , RestaurantDataBase::class.java , "Restaurant DataBase")
            .fallbackToDestructiveMigration()
            .build()

}