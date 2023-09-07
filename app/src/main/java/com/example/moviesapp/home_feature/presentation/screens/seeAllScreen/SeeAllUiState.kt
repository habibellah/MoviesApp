package com.example.moviesapp.home_feature.presentation.screens.seeAllScreen

import com.example.moviesapp.home_feature.domain.model.Movie

data class SeeAllUiState(
   var movieList : List<Movie> = listOf() ,
   var loading : Boolean = false ,
   var requestLoading : Boolean = false,
   var error : Boolean = false ,
   var endReached : Boolean = false ,
   var page : Int = 1
)