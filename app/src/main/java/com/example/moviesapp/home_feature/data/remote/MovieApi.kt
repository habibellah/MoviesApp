package com.example.moviesapp.home_feature.data.remote

import retrofit2.Response
import retrofit2.http.GET
import com.example.moviesapp.BuildConfig
import com.example.moviesapp.home_feature.data.remote.dto.ActorDetailsDto
import com.example.moviesapp.home_feature.data.remote.dto.ActorMoviesDto
import com.example.moviesapp.home_feature.data.remote.dto.MovieActorDto
import com.example.moviesapp.home_feature.data.remote.dto.MovieDetailsDto
import com.example.moviesapp.home_feature.data.remote.dto.MovieDto
import com.example.moviesapp.home_feature.data.remote.dto.MediaReviewDto
import com.example.moviesapp.home_feature.data.remote.dto.TvShowDetailsDto
import com.example.moviesapp.home_feature.data.remote.dto.TvShowDto
import com.example.moviesapp.profile_feature.data.remote.dto.ProfileDTO
import com.example.moviesapp.profile_feature.data.remote.dto.RequestToken
import com.example.moviesapp.profile_feature.data.remote.dto.SessionIdResponse
import com.example.moviesapp.profile_feature.data.remote.dto.UserInputsBody
import com.example.moviesapp.search_feature.data.remote.dto.ActorDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
   @GET("tv/{tvShowCategory}")
   suspend fun getTvShowListBy(
      @Path(value = "tvShowCategory") tvShowCategory : String ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("page")
      page : Int
   ) : Response<TvShowDto>

   @GET("trending/tv/day")
   suspend fun getTrendingTvShowList(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("page")
      page : Int
   ) : Response<TvShowDto>

   @GET("movie/{movieCategory}")
   suspend fun getMovieListBy(
      @Path(value = "movieCategory") movieCategory : String ,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("page")
      page : Int
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

   @GET("{mediaType}/{id}/reviews")
   suspend fun getMediaReviewListBy(
      @Path(value = "id") id : Int ,
      @Path(value = "mediaType") mediaType : String,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<MediaReviewDto>


@GET("tv/{id}")
suspend fun getTvShowDetailsBy(
   @Path(value = "id") id : Int ,
   @Query("api_key")
   apiKey : String = BuildConfig.API_KEY
) : Response<TvShowDetailsDto>

   @GET("discover/movie")
   suspend fun getSearchedMovieListBy(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("with_genres")
      genres : Int?,
   ) : Response<MovieDto>

   @GET("discover/tv")
 suspend  fun getSearchedTvShowListBy(
   @Query("api_key")
   apiKey : String = BuildConfig.API_KEY,
   @Query("with_genres")
   genres : Int?,
   ) : Response<TvShowDto>

   @GET("search/movie")
   suspend  fun searchMovieListBy(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("query")
      query : String,
   ) : Response<MovieDto>

   @GET("search/tv")
   suspend  fun searchTvListBy(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("query")
      query : String,
   ) : Response<TvShowDto>

   @GET("search/person")
   suspend  fun searchActorListBy(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("query")
      query : String,
   ) : Response<ActorDto>

   @GET("authentication/token/new")
   suspend fun getRequestToken(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
   ) : Response<RequestToken>

   @POST("authentication/token/validate_with_login")
   suspend fun checkLoginInformation(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Body userInformation : UserInputsBody
   ) : Response<RequestToken>

   @GET("authentication/session/new")
   suspend fun getSessionId(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("request_token") tokenRequest : String
   ) : Response<SessionIdResponse>

   @GET("account")
   suspend fun getAccountId(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("session_id") sessionId : String
   ) : Response<ProfileDTO>

   @GET("person/{id}")
   suspend fun getActorDetailsBy(
      @Path("id") id : Int,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<ActorDetailsDto>

   @GET("person/{id}/movie_credits")
   suspend fun getActorMoviesBy(
      @Path("id") id : Int,
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY
   ) : Response<ActorMoviesDto>

   @GET("account")
   suspend fun getAccountDetails(
      @Query("api_key")
      apiKey : String = BuildConfig.API_KEY,
      @Query("session_id") sessionId : String
   ) : Response<ProfileDTO>
}
