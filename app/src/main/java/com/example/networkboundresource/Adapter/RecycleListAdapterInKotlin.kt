package com.example.networkboundresource.Adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.Target
import com.example.networkboundresource.Models.Restaurant
import com.example.networkboundresource.databinding.RestaurantItemBinding

class RecycleListAdapterInKotlin(
    imageLoader: RequestManager
) :
    ListAdapter<Restaurant, RecycleListAdapterInKotlin.ViewHolder>(AdapterDiffCallBack()) {
    val imgLoader: RequestManager = imageLoader
        get() {
            return field
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            RestaurantItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            imgLoader
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AdapterDiffCallBack : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.name == newItem.name && oldItem.address == newItem.address
        }
    }

    class ViewHolder(binding: RestaurantItemBinding , imageLoader: RequestManager) : RecyclerView.ViewHolder(binding.getRoot()) {
        var binding: RestaurantItemBinding
        val imageLoader:RequestManager = imageLoader
            get() {
                return field
            }

        fun bind(restaurant: Restaurant?) {
            if (restaurant != null) {
                binding.name.text = restaurant.name
                binding.type.text = restaurant.type
                binding.address.text = restaurant.address
                imageLoader.load(restaurant.logo).into(binding.restaurantImage)
            };
        }

        init {
            this.binding = binding
        }
    }
}



