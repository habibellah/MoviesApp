package com.example.moviesapp.search_feature.presentation.screens.exploreScreen

import com.example.moviesapp.home_feature.domain.model.TvShow

data class ExploreUiState(
   val exploreTvShowState : ExploreTvShowState = ExploreTvShowState()
)

data class ExploreTvShowState(
   val exploreTvShowList : List<TvShow> = listOf() ,
   val loading : Boolean = false,
   val error : Boolean = false
)