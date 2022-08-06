package com.example.networkboundresource.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.networkboundresource.Models.Restaurant;
import com.example.networkboundresource.databinding.RestaurantItemBinding;

public class RecycleAdapterInJava extends ListAdapter<Restaurant , RecycleAdapterInJava.ViewHolder> {
    private final RequestManager imageLoader;
    protected RecycleAdapterInJava(RequestManager imageLoader) {
        super(new AdapterDiffCallBack());
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RestaurantItemBinding.inflate(LayoutInflater.from(parent.getContext())
        , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RestaurantItemBinding binding;
        public ViewHolder(RestaurantItemBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }

        public void bind(Restaurant restaurant){
            if (restaurant != null) {
                binding.name.setText(restaurant.getName());
                binding.type.setText(restaurant.getType());
                binding.address.setText(restaurant.getAddress());
                imageLoader.load(restaurant.getLogo()).into(binding.restaurantImage);
            };
        }
    }
}

class AdapterDiffCallBack extends DiffUtil.ItemCallback<Restaurant>{

    @Override
    public boolean areItemsTheSame(@NonNull Restaurant oldItem, @NonNull Restaurant newItem) {
        return oldItem.getUid().equals(newItem.getUid());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Restaurant oldItem, @NonNull Restaurant newItem) {
        return oldItem.getName().equals(newItem.getName())
                && oldItem.getAddress().equals(newItem.getAddress());
    }
}
