package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.search_feature.domain.model.MediaSearch
import com.example.moviesapp.search_feature.domain.model.util.MediaType
import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
){
    fun toMovie() : Movie{
        return Movie(
            movieId = id,
            movieName = title,
            image = "https://image.tmdb.org/t/p/w500${posterPath}",
            rate = voteAverage.toString(),
            movieGene = genreIds.toString()
        )
    }

    fun toMediaSearch(): MediaSearch{
        return MediaSearch(image = "https://image.tmdb.org/t/p/w500${posterPath}" , mediaType = MediaType.Movie)
    }
}