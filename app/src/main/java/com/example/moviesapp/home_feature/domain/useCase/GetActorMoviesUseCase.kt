package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.ActorDetails
import com.example.moviesapp.home_feature.domain.model.ActorMovies
import com.example.moviesapp.home_feature.domain.repository.ActorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActorMoviesUseCase @Inject constructor(private val actorRepository : ActorRepository){
    fun getActorMoviesBy(id : Int) : Flow<MovieState<List<ActorMovies>>>{
      return actorRepository.getActorMoviesBy(id)
   }
}