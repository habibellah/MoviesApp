package com.example.moviesapp.search_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.search_feature.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMovieListByGenresUseCase @Inject constructor(private val searchRepository : SearchRepository) {
   suspend fun searchMovieListBy(genres : Int?) : Flow<MovieState<List<Movie>>> {
      return searchRepository.searchMovieListBy(genres)
   }
}