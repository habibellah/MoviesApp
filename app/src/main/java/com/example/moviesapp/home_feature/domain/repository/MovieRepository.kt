package com.example.moviesapp.home_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
  suspend fun getPopularMovieList() : Flow<MovieState<List<Movie>>>
}