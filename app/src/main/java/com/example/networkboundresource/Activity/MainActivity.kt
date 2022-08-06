package com.example.networkboundresource.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.view.isVisible
import androidx.lifecycle.asLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.networkboundresource.Adapter.RecycleListAdapterInKotlin
import com.example.networkboundresource.DataBase.RestaurantDataBase
import com.example.networkboundresource.R
import com.example.networkboundresource.Utils.Resource
import com.example.networkboundresource.ViewModel.RestaurantViewModel
import com.example.networkboundresource.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private final val TAG = "MainActivity"

    lateinit var binding:ActivityMainBinding
    lateinit var adapter :RecycleListAdapterInKotlin
    val viewModel: RestaurantViewModel by viewModels()

    @Inject
    lateinit var restaurantDataBase: RestaurantDataBase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            adapter = RecycleListAdapterInKotlin(
                Glide.with(this@MainActivity).applyDefaultRequestOptions(
                    RequestOptions()
                        .error(R.drawable.ic_image_failed)
                        .placeholder(R.drawable.ic_image_loading)
                        .circleCrop()
                )
            )

            recycleView.adapter = adapter
//            restaurantDataBase.RestaurantDao().getAllRestaurant().asLiveData()
//                .observe(this@MainActivity) {
//                    adapter.submitList(it)
//                }
            viewModel.apply {
                result.observe(this@MainActivity){
                    adapter.submitList(it.data)
                    Log.d(TAG, "o nCreate: " + it.data + " Resource: " + it + " error: "+ it.error)
                    shimmerLayout.isVisible = it is Resource.Loading && it.data.isNullOrEmpty()
                    errorConnection.isVisible = it is Resource.Failed && it.data.isNullOrEmpty()
                    errorConnection.text = it.error?.localizedMessage
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (binding.recycleView.adapter == null)
            binding.recycleView.adapter = adapter
    }
}