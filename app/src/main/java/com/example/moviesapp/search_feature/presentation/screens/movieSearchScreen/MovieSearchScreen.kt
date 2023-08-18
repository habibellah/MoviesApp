package com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen

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
fun MovieSearchScreen(
   movieSearchViewModel : MovieSearchViewModel = hiltViewModel()
){
   val movieSearchUiState = movieSearchViewModel.movieSearchUiState.collectAsState()
   MovieSearchScreenContent(movieSearchUiState.value){ genres ->
      movieSearchViewModel.getMovieListBy(genres)
   }
}

@Composable
private fun MovieSearchScreenContent(searchMovieList : MovieSearchUiState,onMovieSearchClick:(Int?)->Unit) {
   Box(modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)){
      Column {
         HeaderMovieSearchScreen{
           onMovieSearchClick(it)
         }
         MovieSearchScreenBody(movieList = searchMovieList.movieList)
      }
   }
}
