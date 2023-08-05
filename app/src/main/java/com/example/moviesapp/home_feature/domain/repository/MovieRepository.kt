package com.example.moviesapp.home_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
  suspend fun getMovieListBy(category : String) : Flow<MovieState<List<Movie>>>

  suspend fun getMovieDetailsBy(id : Int) : Flow<MovieState<MovieDetails>>

  suspend fun getSimilarMovieBy(id : Int) : Flow<MovieState<List<Movie>>>
}