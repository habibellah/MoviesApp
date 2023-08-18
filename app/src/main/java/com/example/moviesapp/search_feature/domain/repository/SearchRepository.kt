package com.example.moviesapp.search_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
   suspend fun searchMovieListBy(genres : Int?) : Flow<MovieState<List<Movie>>>
   fun searchTvShowListBy(genres : Int?) : Flow<MovieState<List<TvShow>>>
}