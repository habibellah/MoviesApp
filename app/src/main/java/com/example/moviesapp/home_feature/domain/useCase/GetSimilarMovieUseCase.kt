package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarMovieUseCase @Inject constructor(private val movieRepository : MovieRepository) {
   suspend fun getSimilarMovieBy(id : Int) : Flow<MovieState<List<Movie>>>{
      return movieRepository.getSimilarMovieBy(id)
   }
}