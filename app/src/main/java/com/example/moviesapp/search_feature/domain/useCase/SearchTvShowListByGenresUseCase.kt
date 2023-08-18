package com.example.moviesapp.search_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.search_feature.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchTvShowListByGenresUseCase @Inject constructor(private val searchRepository : SearchRepository) {
   suspend fun searchTvShowListByGenresUseCase(genres : Int?) : Flow<MovieState<List<TvShow>>>{
      return searchRepository.searchTvShowListBy(genres)
   }
}