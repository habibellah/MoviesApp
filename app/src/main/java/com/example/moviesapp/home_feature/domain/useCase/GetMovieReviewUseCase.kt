package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieReviewUseCase @Inject constructor(private val movieRepository : MovieRepository) {
   suspend fun getMovieReviewListBy(id : Int) : Flow<MovieState<List<Review>>>{
      return movieRepository.getMovieReviewListBy(id)
   }
}