package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.MovieDetails
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val movieRepository : MovieRepository){
  suspend fun getMovieDetailsBy(id : Int) : Flow<MovieState<MovieDetails>>{
      return movieRepository.getMovieDetailsBy(id)
   }
}