package com.example.moviesapp.home_feature.domain

sealed class MovieState<out T> {
   data class Success<T>(val data : T) : MovieState<T>()
   data class Error(val message : String) : MovieState<Nothing>()
   object Loading : MovieState<Nothing>()
}