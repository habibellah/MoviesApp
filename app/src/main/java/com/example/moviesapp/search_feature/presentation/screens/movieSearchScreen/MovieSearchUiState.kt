package com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen

import com.example.moviesapp.home_feature.domain.model.Movie

data class MovieSearchUiState(
   val movieList : List<Movie> = listOf(),
   val error : Boolean = false,
   val loading : Boolean = false
)