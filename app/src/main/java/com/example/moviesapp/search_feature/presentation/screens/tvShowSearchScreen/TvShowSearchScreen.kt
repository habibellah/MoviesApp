package com.example.moviesapp.search_feature.presentation.screens.tvShowSearchScreen

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
fun TvShowSearchScreen(
   tvShowSearchViewModel : TvShowSearchViewModel = hiltViewModel()
){
   val tvShowSearchUiState = tvShowSearchViewModel.movieSearchUiState.collectAsState()
   TvShowSearchScreenContent(tvShowSearchUiState.value){ genres ->
      tvShowSearchViewModel.getTvShowListBy(genres)
   }
}

@Composable
private fun TvShowSearchScreenContent(tvShowState : TvShowSearchUiState,onSearchTvShowCategoryClick : (Int?) -> Unit) {
   Box(modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)){
      Column {
         TvShowSearchScreenHeader{ genres ->
            onSearchTvShowCategoryClick(genres)
         }
         TvShowSearchScreenBody(tvShowList = tvShowState.tvShowList)
      }
   }
}
