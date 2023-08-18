package com.example.moviesapp.search_feature.presentation.screens.exploreScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExploreScreen(
   exploreViewModel : ExploreViewModel = hiltViewModel()
){
   val exploreUiState = exploreViewModel.exploreUiState.collectAsState()
   ExploreScreenContent(exploreUiState.value)
}

@Composable
private fun ExploreScreenContent(exploreState : ExploreUiState) {
   Box(modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)){
      Column {
         HeaderExploreScreen()
         ExploreScreenBody(trendingTodayList =  exploreState.exploreTvShowState.exploreTvShowList)
      }
   }
}
