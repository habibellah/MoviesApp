package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.ActorDetails
import com.example.moviesapp.home_feature.domain.repository.ActorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActorDetailsUseCase @Inject constructor(private val actorRepository : ActorRepository){
    fun getActorDetailsBy(id : Int) : Flow<MovieState<ActorDetails>>{
      return actorRepository.getActorDetailsBy(id)
   }
}