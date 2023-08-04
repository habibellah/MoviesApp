package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
   homeViewModel : HomeViewModel = hiltViewModel()
) {
   val homeUiState = homeViewModel.homeUiState.collectAsState()
   HomeScreenContent(homeUiState)
}

@Composable
private fun HomeScreenContent(homeUiState : State<HomeUiState>) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)
   ) {
      Column(modifier = Modifier.fillMaxSize()) {
         HeaderHomeScreen(
            homeUiState.value.popularMovie.popularMovieList
         )
         HomeScreenBody(
            airingTodayTvShowList = homeUiState.value.airingTodayTvShow.airingTodayTvShowList ,
            onTheAirTvShowList = homeUiState.value.onTheAirTvShow.onTheAirTvShowList ,
            trendingTvShowList = homeUiState.value.trendingTvShow.trendingTvShowList ,
            nowStreamingMovieList = homeUiState.value.nowStreamingMovie.nowStreamingMovieList ,
            upComingMovieList = homeUiState.value.upComingMovie.upComingMovieList ,
            topRatedMovieList = homeUiState.value.topRatedMovie.topRatedMovieList ,
            seeMoreClick = { /*TODO*/ }) {
         }
      }
   }
}
