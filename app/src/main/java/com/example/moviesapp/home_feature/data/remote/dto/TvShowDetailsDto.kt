package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.TvShowDetails
import com.google.gson.annotations.SerializedName

data class TvShowDetailsDto(
    @SerializedName("adult")
    val adult: Boolean ,
    @SerializedName("backdrop_path")
    val backdropPath: Any ,
    @SerializedName("created_by")
    val createdBy: List<CreatedBy> ,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Int> ,
    @SerializedName("first_air_date")
    val firstAirDate: String ,
    @SerializedName("genres")
    val genres: List<Int> ,
    @SerializedName("homepage")
    val homepage: String ,
    @SerializedName("id")
    val id: Int ,
    @SerializedName("in_production")
    val inProduction: Boolean ,
    @SerializedName("languages")
    val languages: List<Any> ,
    @SerializedName("last_air_date")
    val lastAirDate: String ,
    @SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir ,
    @SerializedName("name")
    val name: String ,
    @SerializedName("networks")
    val networks: List<Network> ,
    @SerializedName("next_episode_to_air")
    val nextEpisodeToAir: Any ,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int ,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int ,
    @SerializedName("origin_country")
    val originCountry: List<String> ,
    @SerializedName("original_language")
    val originalLanguage: String ,
    @SerializedName("original_name")
    val originalName: String ,
    @SerializedName("overview")
    val overview: String ,
    @SerializedName("popularity")
    val popularity: Double ,
    @SerializedName("poster_path")
    val posterPath: String ,
    @SerializedName("production_companies")
    val productionCompanies: List<Any> ,
    @SerializedName("production_countries")
    val productionCountries: List<Any> ,
    @SerializedName("seasons")
    val seasonDtos: List<SeasonDto> ,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<Any> ,
    @SerializedName("status")
    val status: String ,
    @SerializedName("tagline")
    val tagline: String ,
    @SerializedName("type")
    val type: String ,
    @SerializedName("vote_average")
    val voteAverage: Double ,
    @SerializedName("vote_count")
    val voteCount: Int
){
    fun toTvShowDetails() : TvShowDetails{
        return TvShowDetails(
            tvShowName = name ,
            tvShowId = id ,
            image = "https://image.tmdb.org/t/p/w500${posterPath}" ,
            releaseDate = firstAirDate ,
            genre = genres.toString() ,
            rate = voteAverage.toString() ,
            overView = overview ,
            reviewCount = voteCount.toString() ,
            season = seasonDtos.map { it.toSeason() }
        )
    }
}