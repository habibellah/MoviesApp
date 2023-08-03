package com.example.moviesapp.home_feature.data.remote.dto

import retrofit2.Response
import retrofit2.http.GET
import com.example.moviesapp.BuildConfig
import retrofit2.http.Query

interface MovieApi {
   @GET("movie/popular")
   suspend fun getPopularMovieList(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieDto>
}
