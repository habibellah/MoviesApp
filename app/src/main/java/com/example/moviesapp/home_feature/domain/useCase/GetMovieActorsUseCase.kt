package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Actor
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieActorsUseCase @Inject constructor(private val movieRepository : MovieRepository) {
   suspend fun getMovieActorListBy(id : Int) : Flow<MovieState<List<Actor>>> {
      return movieRepository.getMovieActorListBy(id)
   }
}