package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TvShowDetailsScreen(
   tvShowDetailsViewModel : TvShowDetailsViewModel = hiltViewModel()
){
   val tvShowDetailsState = tvShowDetailsViewModel.tvShowDetailsUiState.collectAsState()
   TvShowDetailsContent(tvShowDetailsState)
}

@Composable
private fun TvShowDetailsContent(tvShowDetailsState : State<TvShowDetailsUiState>) {
   Box(modifier = Modifier.fillMaxSize()){
      Column (modifier = Modifier
         .verticalScroll(rememberScrollState())){
         HeaderTvShowDetails(tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.image ?: "")
         TvShowDetailsBody(
            seasonsList = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.season ?: emptyList() ,
            reviewList = tvShowDetailsState.value.tvShowReviewState.reviewList ,
            tvShowName = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.tvShowName ?: "" ,
            releaseDate = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.releaseDate ?: "" ,
            genres = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.genre ?: "" ,
            rate = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.rate ?: "" ,
            voteCount = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.reviewCount ?: "" ,
            overView = tvShowDetailsState.value.tvShowDetailsState.tvShowDetails?.overView ?: ""
         )
      }
   }
}
