package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnTheAirTvShowUseCase @Inject constructor(private val tvShowRepository : TvShowRepository){
   suspend fun getOnTheAirTvShowList() : Flow<MovieState<List<TvShow>>> {
      return tvShowRepository.getTvShowListBy("on_the_air")
   }
}