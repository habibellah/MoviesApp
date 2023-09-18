package com.example.moviesapp.home_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.ActorDetails
import com.example.moviesapp.home_feature.domain.model.ActorMovies
import kotlinx.coroutines.flow.Flow

interface ActorRepository {
   fun getActorDetailsBy(id : Int) : Flow<MovieState<ActorDetails>>

   fun getActorMoviesBy(id : Int) : Flow<MovieState<List<ActorMovies>>>
}