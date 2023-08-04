package com.example.moviesapp.core.di

import com.example.moviesapp.home_feature.data.remote.dto.MovieApi
import com.example.moviesapp.home_feature.data.repository.MovieRepositoryImpl
import com.example.moviesapp.home_feature.data.repository.TvShowRepositoryImpl
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

   @Provides
   fun provideMovieRepository(movieApi : MovieApi) : MovieRepository{
      return MovieRepositoryImpl(movieApi)
   }

   @Provides
   fun provideTvShowRepository(movieApi : MovieApi) : TvShowRepository{
      return TvShowRepositoryImpl(movieApi = movieApi)
   }
}