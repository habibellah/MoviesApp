package com.example.moviesapp.home_feature.data.remote

import retrofit2.Response
import retrofit2.http.GET
import com.example.moviesapp.BuildConfig
import com.example.moviesapp.home_feature.data.remote.dto.MovieActorDto
import com.example.moviesapp.home_feature.data.remote.dto.MovieDetailsDto
import com.example.moviesapp.home_feature.data.remote.dto.MovieDto
import com.example.moviesapp.home_feature.data.remote.dto.MovieReviewDto
import com.example.moviesapp.home_feature.data.remote.dto.TvShowDetailsDto
import com.example.moviesapp.home_feature.data.remote.dto.TvShowDto
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
   @GET("tv/{tvShowCategory}")
   suspend fun getTvShowListBy(
      @Path(value = "tvShowCategory") tvShowCategory : String ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<TvShowDto>

   @GET("trending/tv/day")
   suspend fun getTrendingTvShowList(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<TvShowDto>

   @GET("movie/{movieCategory}")
   suspend fun getMovieListBy(
      @Path(value = "movieCategory") movieCategory : String ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieDto>

   @GET("movie/{id}")
   suspend fun getMovieDetailsBy(
      @Path(value = "id") id : Int ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieDetailsDto>

   @GET("movie/{id}/similar")
   suspend fun getSimilarMovieBy(
      @Path(value = "id") id : Int ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieDto>

   @GET("movie/{id}/credits")
   suspend fun getMovieActorBy(
      @Path(value = "id") id : Int ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieActorDto>

   @GET("movie/{id}/reviews")
   suspend fun getMovieReviewListBy(
      @Path(value = "id") id : Int ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieReviewDto>

@GET("tv/{id}")
suspend fun getTvShowDetailsBy(
   @Path(value = "id") id : Int ,
   @Query("api_key")
   apiKey : String = BuildConfig.API_KEY
) : Response<TvShowDetailsDto>
}
