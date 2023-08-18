package com.example.moviesapp.search_feature.presentation.screens.tvShowSearchScreen

import com.example.moviesapp.home_feature.domain.model.TvShow

data class TvShowSearchUiState(
   val tvShowList : List<TvShow> = listOf(),
   val error : Boolean = false,
   val loading : Boolean = false
)