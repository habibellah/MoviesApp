package com.example.moviesapp.core.di

import com.example.moviesapp.home_feature.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   private const val BASE_URL = "https://api.themoviedb.org/3/"
   @Singleton
   @Provides
   fun provideMovieService() : MovieApi {
      val client : OkHttpClient = OkHttpClient.Builder()
         .connectTimeout(60, TimeUnit.SECONDS)
         .writeTimeout(120, TimeUnit.SECONDS)
         .readTimeout(60, TimeUnit.SECONDS)
         .build()
      return Retrofit.Builder()
         .baseUrl(BASE_URL)
         .client(client)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(MovieApi::class.java)
   }
}