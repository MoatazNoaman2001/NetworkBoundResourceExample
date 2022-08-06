package com.example.networkboundresource.DI

import android.content.Context
import androidx.annotation.NonNull
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.networkboundresource.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ImageLoader {

    @Provides
    @NonNull
    @Singleton
    fun getGlide(@ApplicationContext context: Context?): RequestManager? {
        return Glide.with(context!!).applyDefaultRequestOptions(
            RequestOptions()
                .error(R.drawable.ic_image_failed)
                .placeholder(R.drawable.ic_image_loading)
        )
    }
}