package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowDto(
   @SerializedName("page")
    val page: Int ,
   @SerializedName("results")
    val results: List<TvShowResult> ,
   @SerializedName("total_pages")
    val totalPages: Int ,
   @SerializedName("total_results")
    val totalResults: Int
)