package com.example.moviesapp.home_feature.data.repository

import com.example.moviesapp.home_feature.data.remote.dto.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TvShowRepositoryImpl  (private val movieApi : MovieApi) : TvShowRepository {
   override suspend fun getAiringTodayTvShowList() : Flow<MovieState<List<TvShow>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getAiringTodayTvShowList()
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.results.map { it.toTvShow() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }
}