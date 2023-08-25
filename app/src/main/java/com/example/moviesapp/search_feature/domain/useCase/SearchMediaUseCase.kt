package com.example.moviesapp.search_feature.domain.useCase

import android.util.Log
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.search_feature.domain.model.MediaSearch
import com.example.moviesapp.search_feature.domain.model.util.MediaType
import com.example.moviesapp.search_feature.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMediaUseCase @Inject constructor(private val searchRepository : SearchRepository){

   suspend fun searchMediaByQuery(query : String,mediaType : String) : Flow<MovieState<List<MediaSearch>>> {
      return when (mediaType) {
         MediaType.TvShow.toString() -> {
            searchRepository.searchTvShowBy(query)
         }
         MediaType.Movie.toString() -> {
            searchRepository.searchMovieBy(query)
         }
         MediaType.Actor.toString() -> {
            searchRepository.searchActorBy(query)
         }

         else -> {
            return flow { emit(MovieState.Success(emptyList())) }
         }
      }
   }
}