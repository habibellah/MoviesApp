package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviesapp.core.presentation.navigation.routes.navigateToActorDetailsScreen
import com.example.moviesapp.core.presentation.navigation.routes.navigateToMovieDetailsScreen

@Composable
fun MovieDetailsScreen(
   movieDetailsViewModel : MovieDetailsViewModel = hiltViewModel(),
   navController : NavController
) {
   val movieDetailsUiState = movieDetailsViewModel.movieDetailsUiState.collectAsState()
   MovieDetailsContent(movieDetailsUiState, onSimilarMovieItemClick = {
         movieId ->
      navController.navigateToMovieDetailsScreen(movieId)
   }){ actorId ->
      navController.navigateToActorDetailsScreen(actorId)
   }
}

@Composable
private fun MovieDetailsContent(movieDetailsUiState : State<MovieDetailsUiState>, onSimilarMovieItemClick:(movieId : Int) -> Unit,onActorClick:(actorId : Int)->Unit) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)
   ) {
      Column(
         modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
      ) {

            HeaderMovieDetails(
               imageUrl = movieDetailsUiState.value.movieDetailsState.movieDetails?.image ?: ""
            )

         MovieDetailsBody(
            actorList = movieDetailsUiState.value.actorState.actorList ,
            reviewList = movieDetailsUiState.value.movieReviewState.reviewList ,
            similarMovieList = movieDetailsUiState.value.similarMovieState.similarMovieList ,
            movieName = movieDetailsUiState.value.movieDetailsState.movieDetails?.movieName ?: "" ,
            releaseDate = movieDetailsUiState.value.movieDetailsState.movieDetails?.releaseDate ?: "" ,
            duration = movieDetailsUiState.value.movieDetailsState.movieDetails?.duration ?: "" ,
            categories = movieDetailsUiState.value.movieDetailsState.movieDetails?.genre ?: "" ,
            rate = movieDetailsUiState.value.movieDetailsState.movieDetails?.rate ?: "" ,
            reviewCount = movieDetailsUiState.value.movieDetailsState.movieDetails?.reviewCount ?: "" ,
            overView = movieDetailsUiState.value.movieDetailsState.movieDetails?.overView ?: "",
            onSimilarMovieItemClick = {movieId ->
               onSimilarMovieItemClick(movieId)
            }
         ){ actorId ->
            onActorClick(actorId)
         }
      }
   }
}
