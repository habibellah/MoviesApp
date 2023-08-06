package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.Review
import com.google.gson.annotations.SerializedName

data class MovieReviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)