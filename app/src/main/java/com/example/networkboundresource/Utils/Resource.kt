package com.example.networkboundresource.Utils

sealed class Resource<T>(val data: T? = null, val error: Throwable? = null) {
    class Success<T>(data: T) : Resource<T>()
    class Loading<T>(data: T? = null) : Resource<T>()
    class Failed<T>(throwable: Throwable, msg: T) : Resource<T>()

}