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
import androidx.navigation.NavController
import com.example.moviesapp.core.presentation.navigation.routes.navigateToMovieDetailsScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToSeeAllScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToTvShowDetailsScreen
import com.example.moviesapp.search_feature.domain.model.util.MediaType

@Composable
fun HomeScreen(
   homeViewModel : HomeViewModel = hiltViewModel(),
   navController : NavController
) {
   val homeUiState = homeViewModel.homeUiState.collectAsState()
   HomeScreenContent(homeUiState, seeMoreClick = {mediaType,mediaCategory ->
      navController.navigateToSeeAllScreen(mediaType, mediaCategory)
   }){mediaType, mediaId ->
      if(mediaType == MediaType.Movie){
         navController.navigateToMovieDetailsScreen(mediaId)
      }else{
         navController.navigateToTvShowDetailsScreen(mediaId)
      }
   }
}

@Composable
private fun HomeScreenContent(homeUiState : State<HomeUiState>,seeMoreClick:(mediaType : MediaType,mediaCategory : String)->Unit, onItemClick : (mediaType : MediaType ,id : Int) -> Unit) {
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
            seeMoreClick = {mediaType,mediaCategory -> seeMoreClick(mediaType, mediaCategory) }) {mediaType,mediaId ->
            onItemClick(mediaType,mediaId)
         }
      }
   }
}
