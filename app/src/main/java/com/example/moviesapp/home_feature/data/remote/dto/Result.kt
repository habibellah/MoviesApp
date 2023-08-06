package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.Review
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("author")
    val author: String,
    @SerializedName("author_details")
    val authorDetails: AuthorDetails,
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
){
    fun toReview() : Review {
        return Review(
            reviewerName = author , reviewContent = content , date = createdAt
        )
    }
}