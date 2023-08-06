package com.example.moviesapp.home_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MovieActorDto(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
)