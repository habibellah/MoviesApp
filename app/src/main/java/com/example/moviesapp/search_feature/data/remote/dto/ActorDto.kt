package com.example.moviesapp.search_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ActorDto(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)