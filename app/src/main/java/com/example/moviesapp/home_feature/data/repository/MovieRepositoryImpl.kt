package com.example.moviesapp.home_feature.data.repository

import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Actor
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.MovieDetails
import com.example.moviesapp.home_feature.domain.model.Review
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

   override suspend fun getMovieDetailsBy(id : Int) : Flow<MovieState<MovieDetails>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getMovieDetailsBy(id)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.toMovieDetails()))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   override suspend fun getSimilarMovieBy(id : Int) : Flow<MovieState<List<Movie>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getSimilarMovieBy(id)
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

   override suspend fun getMovieActorListBy(id : Int) : Flow<MovieState<List<Actor>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getMovieActorBy(id)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.cast.map { it.toActor() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   override suspend fun getMovieReviewListBy(id : Int) : Flow<MovieState<List<Review>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getMovieReviewListBy(id)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.results.map { it.toReview() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }
}