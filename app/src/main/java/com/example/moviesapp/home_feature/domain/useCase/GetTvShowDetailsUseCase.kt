package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.TvShowDetails
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTvShowDetailsUseCase @Inject constructor(private val tvShowRepository : TvShowRepository){
   suspend fun getTvShowDetailsBy(id : Int) : Flow<MovieState<TvShowDetails>>{
      return tvShowRepository.getTvShowDetailsBy(id)
   }
}