package com.example.moviesapp.core.di

import android.content.Context
import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.data.repository.ActorRepositoryImpl
import com.example.moviesapp.home_feature.data.repository.MovieRepositoryImpl
import com.example.moviesapp.home_feature.data.repository.TvShowRepositoryImpl
import com.example.moviesapp.home_feature.domain.repository.ActorRepository
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import com.example.moviesapp.profile_feature.data.local.SharedPreferences
import com.example.moviesapp.profile_feature.data.repository.AuthenticationRepositoryImpl
import com.example.moviesapp.profile_feature.domain.repository.AuthenticationRepository
import com.example.moviesapp.search_feature.data.repository.SearchRepositoryImpl
import com.example.moviesapp.search_feature.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.moviesapp.profile_feature.data.local.SharedPrefrencesUserData

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

   @Provides
   fun provideSearchRepository(movieApi : MovieApi) : SearchRepository{
      return SearchRepositoryImpl(movieApi)
   }

   @Provides
   fun provideActorRepository(movieApi : MovieApi) : ActorRepository{
      return ActorRepositoryImpl(movieApi)
   }

   @Provides
   fun provideSharedPreferencesDataStore(@ApplicationContext context : Context) : SharedPreferences{
      return SharedPrefrencesUserData(context)
   }
   @Provides
   fun provideAuthenticationRepository(movieApi : MovieApi,sharedPreferences : SharedPreferences) : AuthenticationRepository{
      return AuthenticationRepositoryImpl(movieApi,sharedPreferences)
   }
}