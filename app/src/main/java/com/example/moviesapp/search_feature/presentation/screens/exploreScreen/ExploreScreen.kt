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
import androidx.navigation.NavController
import com.example.moviesapp.core.presentation.navigation.routes.navigateToGeneralSearchScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToMovieSearchScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToTvShowDetailsScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToTvShowSearchScreen
import com.example.moviesapp.search_feature.domain.model.util.MediaType

@Composable
fun ExploreScreen(
   exploreViewModel : ExploreViewModel = hiltViewModel() ,
   navController : NavController
) {
   val exploreUiState = exploreViewModel.exploreUiState.collectAsState()
   ExploreScreenContent(exploreUiState.value , onGeneralSearchClick = {
      navController.navigateToGeneralSearchScreen()
   } , onMovieButtonClick = {
      navController.navigateToMovieSearchScreen()
   } , onTvShowButtonClick = {
      navController.navigateToTvShowSearchScreen()
   }) { mediaId ->
      navController.navigateToTvShowDetailsScreen(mediaId)
   }
}

@Composable
private fun ExploreScreenContent(
   exploreState : ExploreUiState ,
   onGeneralSearchClick : () -> Unit ,
   onMovieButtonClick : () -> Unit ,
   onTvShowButtonClick : () -> Unit ,
   onExploreMediaClick : (Int) -> Unit
) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)
   ) {
      Column {
         HeaderExploreScreen(
            onMovieButtonClick = { onMovieButtonClick() } ,
            onTvShowButtonClick = { onTvShowButtonClick() } ,
            onGeneralSearchClick = { onGeneralSearchClick() })
         ExploreScreenBody(trendingTodayList = exploreState.exploreTvShowState.exploreTvShowList) { mediaId ->
            onExploreMediaClick(mediaId)
         }
      }
   }
}
