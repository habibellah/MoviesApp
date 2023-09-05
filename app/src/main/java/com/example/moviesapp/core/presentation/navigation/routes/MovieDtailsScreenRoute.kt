package com.example.moviesapp.core.presentation.navigation.routes

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.MovieDetailsScreen

private const val ROUTE = "movieDetailsScreen"

fun NavController.navigateToMovieDetailsScreen() {
   navigate(ROUTE)
}

fun NavGraphBuilder.movieDetailsScreenRoute() {
   composable(ROUTE
   ) {
      MovieDetailsScreen()
   }
}

//class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {
//   val id: Int = checkNotNull(savedStateHandle.get<Int>(ID_ARG))
//
//   companion object {
//      const val ID_ARG = "id"
//   }
//}