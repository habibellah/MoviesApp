package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.domain.model.TvShowDetails

data class TvShowDetailsUiState(
val tvShowDetailsState : TvShowDetailsState = TvShowDetailsState(),
val tvShowReviewState : TvShowReviewState = TvShowReviewState()
)

data class TvShowDetailsState(
   val tvShowDetails : TvShowDetails? = null,
   val error : Boolean = false,
   val loading : Boolean = false
)
data class TvShowReviewState(
   val reviewList : List<Review> = listOf() ,
   val loading : Boolean = false ,
   val error : Boolean = false
)