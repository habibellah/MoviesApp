package com.example.moviesapp.home_feature.data.repository

import android.util.Log
import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.ActorDetails
import com.example.moviesapp.home_feature.domain.model.ActorMovies
import com.example.moviesapp.home_feature.domain.repository.ActorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ActorRepositoryImpl (private val movieApi : MovieApi): ActorRepository {
   override fun getActorDetailsBy(id : Int) : Flow<MovieState<ActorDetails>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getActorDetailsBy(id)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.toActorDetails()))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   override fun getActorMoviesBy(id : Int) : Flow<MovieState<List<ActorMovies>>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getActorMoviesBy(id)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.cast!!.map { it.toActorMovie() }))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }
}