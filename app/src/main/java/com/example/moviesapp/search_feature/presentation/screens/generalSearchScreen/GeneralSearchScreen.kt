package com.example.moviesapp.search_feature.presentation.screens.generalSearchScreen

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
import com.example.moviesapp.core.presentation.navigation.routes.navigateToMovieDetailsScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToTvShowDetailsScreen
import com.example.moviesapp.search_feature.domain.model.util.MediaType

@Composable
fun GeneralSearchScreen(
   generalSearchViewModel : GeneralSearchViewModel = hiltViewModel(),
   navController : NavController
) {
   val generalSearchUiState = generalSearchViewModel.generalSearchUiState.collectAsState()
   GeneralSearchScreenContent(generalSearchUiState.value ,
      onMediaItemClick = {mediaType, mediaId ->
         when (mediaType) {
            MediaType.Movie -> {
               navController.navigateToMovieDetailsScreen(mediaId)
            }
            MediaType.TvShow -> {
               navController.navigateToTvShowDetailsScreen(mediaId)
            }
            else -> {

            }
         }
      }) { query , mediaType ->
      generalSearchViewModel.searchMediaByQuery(query = query , mediaType = mediaType)
   }
}

@Composable
private fun GeneralSearchScreenContent(
   generalSearchUiState : GeneralSearchUiState ,
   onMediaItemClick : (mediaType : MediaType , mediaId : Int) -> Unit ,
   onSearchMedia : (String , String) -> Unit
) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)
   ) {
      Column {
         GeneralScreenHeader { query , mediaType ->
            onSearchMedia(query , mediaType)
         }
         GeneralSearchBody(searchList = generalSearchUiState.mediaSearchList) { mediaType , mediaId ->
            onMediaItemClick(mediaType , mediaId)
         }
      }
   }
}
