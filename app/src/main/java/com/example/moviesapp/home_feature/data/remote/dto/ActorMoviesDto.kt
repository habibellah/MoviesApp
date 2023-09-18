package com.example.moviesapp.home_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ActorMoviesDto(
    @SerializedName("cast")
    val cast: List<CastX>?,
    @SerializedName("crew")
    val crew: List<Any>?,
    @SerializedName("id")
    val id: Int?
)