package com.example.moviesapp.home_feature.data.repository

import com.example.moviesapp.home_feature.data.remote.dto.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl (private val movieApi : MovieApi): MovieRepository {
   override suspend fun getMovieListBy(category : String) : Flow<MovieState<List<Movie>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getMovieListBy(category)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.movieResults.map { it.toMovie() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }
}