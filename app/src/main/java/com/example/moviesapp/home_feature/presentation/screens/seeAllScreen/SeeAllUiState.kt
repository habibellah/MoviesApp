package com.example.moviesapp.home_feature.presentation.screens.seeAllScreen

import com.example.moviesapp.home_feature.domain.model.Media

data class SeeAllUiState(
   var mediaList : List<Media> = listOf() ,
   var loading : Boolean = false ,
   var requestLoading : Boolean = false ,
   var error : Boolean = false ,
   var endReached : Boolean = false ,
   var page : Int = 1
)