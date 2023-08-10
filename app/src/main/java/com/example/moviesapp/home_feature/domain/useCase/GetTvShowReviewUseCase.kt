package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTvShowReviewUseCase @Inject constructor(private val tvShowRepository : TvShowRepository) {
   suspend fun getTvShowReviewList(id : Int) : Flow<MovieState<List<Review>>>{
      return tvShowRepository.getTvShowReviewList(id)
   }
}