package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import com.example.moviesapp.home_feature.domain.model.TvShowDetails

data class TvShowDetailsUiState(
   val tvShowDetails : TvShowDetails? = null,
   val error : Boolean = false,
   val loading : Boolean = false
)