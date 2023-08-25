package com.example.moviesapp.search_feature.presentation.screens.generalSearchScreen

import com.example.moviesapp.search_feature.domain.model.MediaSearch

data class GeneralSearchUiState(
   val mediaSearchList : List<MediaSearch> = listOf(),
   val loading : Boolean = false,
   val error : Boolean = false
)