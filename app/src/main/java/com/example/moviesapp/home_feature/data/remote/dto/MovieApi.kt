package com.example.moviesapp.home_feature.data.remote.dto

import retrofit2.Response
import retrofit2.http.GET
import com.example.moviesapp.BuildConfig
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
  @GET("tv/{tvShowCategory}")
  suspend fun getTvShowListBy(
     @Path(value = "tvShowCategory") tvShowCategory : String ,
     @Query("api_key")
     apiKey : String = BuildConfig.API_KEY
  ) : Response<TvShowDto>

   @GET("movie/{movieCategory}")
   suspend fun getMovieListBy(
      @Path(value = "movieCategory") movieCategory : String ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MovieDto>
}
