package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import com.example.moviesapp.home_feature.domain.model.Movie

data class HomeUiState(
   val popularMovieList : List<Movie> = listOf() ,
   val loading : Boolean = false ,
   val error : Boolean = false
)