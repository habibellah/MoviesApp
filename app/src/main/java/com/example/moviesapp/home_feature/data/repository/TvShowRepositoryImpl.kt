package com.example.moviesapp.home_feature.data.repository

import android.util.Log
import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.home_feature.domain.model.TvShowDetails
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TvShowRepositoryImpl  (private val movieApi : MovieApi) : TvShowRepository {

   override suspend fun getTvShowListBy(category : String) : Flow<MovieState<List<TvShow>>> {
    return  flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getTvShowListBy(category)
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

   override suspend fun getTrendingTvShowList() : Flow<MovieState<List<TvShow>>> {
      return  flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getTrendingTvShowList()
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

   override suspend fun getTvShowDetailsBy(id : Int) : Flow<MovieState<TvShowDetails>> {
      return  flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getTvShowDetailsBy(id)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.toTvShowDetails()))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   override suspend fun getTvShowReviewList(id : Int) : Flow<MovieState<List<Review>>> {
      return  flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getTvShowReviewListBy(id)
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