package com.example.moviesapp.search_feature.data.repository

import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.search_feature.domain.model.MediaSearch
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

   override fun searchTvShowListBy(genres : Int?) : Flow<MovieState<List<TvShow>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getSearchedTvShowListBy(genres = genres)
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

   override suspend fun searchMovieBy(query : String) : Flow<MovieState<List<MediaSearch>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.searchMovieListBy(query = query)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.movieResults.map { it.toMediaSearch() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   override suspend fun searchTvShowBy(query : String) : Flow<MovieState<List<MediaSearch>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.searchTvListBy(query = query)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.results.map { it.toMediaSearch() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   override suspend fun searchActorBy(query : String) : Flow<MovieState<List<MediaSearch>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.searchActorListBy(query = query)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.results.map { it.toMediaSearch() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }
}