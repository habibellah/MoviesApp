package com.example.moviesapp.search_feature.data.repository

import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.search_feature.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(
   private val movieApi : MovieApi
) : SearchRepository {
   override suspend fun searchMovieListBy(genres : Int?) : Flow<MovieState<List<Movie>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getSearchedMovieListBy(genres = genres)
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