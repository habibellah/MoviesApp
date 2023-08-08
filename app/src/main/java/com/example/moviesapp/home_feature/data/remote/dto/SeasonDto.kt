package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.Season
import com.google.gson.annotations.SerializedName

data class SeasonDto(
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode_count")
    val episodeCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: Any,
    @SerializedName("season_number")
    val seasonNumber: Int,
    @SerializedName("vote_average")
    val voteAverage: Double
){
    fun toSeason() : Season{
        return Season(
            airDate = airDate ,
            episodeCount = episodeCount ,
            id = id ,
            name = name ,
            overview = overview ,
            posterPath = "https://image.tmdb.org/t/p/w500${posterPath}" ,
            seasonNumber = seasonNumber ,
            voteAverage = voteAverage
        )
    }
}