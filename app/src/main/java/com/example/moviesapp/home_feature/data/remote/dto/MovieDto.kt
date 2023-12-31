package com.example.moviesapp.home_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MovieDto(
   @SerializedName("page")
    val page: Int ,
   @SerializedName("results")
    val movieResults: List<MovieResult> ,
   @SerializedName("total_pages")
    val totalPages: Int ,
   @SerializedName("total_results")
    val totalResults: Int
)