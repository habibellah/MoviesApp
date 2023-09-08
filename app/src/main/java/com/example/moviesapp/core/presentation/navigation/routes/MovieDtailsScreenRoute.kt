package com.example.moviesapp.core.presentation.navigation.routes

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.core.presentation.navigation.routes.MovieDetailsArgs.Companion.ID_ARG
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.MovieDetailsScreen

private const val ROUTE = "movieDetailsScreen"

fun NavController.navigateToMovieDetailsScreen(movieId : Int) {
   navigate("$ROUTE/$movieId")
}

fun NavGraphBuilder.movieDetailsScreenRoute(navController : NavController) {
   composable("$ROUTE/{$ID_ARG}",
   arguments = listOf(
      navArgument(ID_ARG){
         type = NavType.IntType
         defaultValue = 0
      }
   )
   ) {
      MovieDetailsScreen(navController = navController)
   }
}

class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {
   val id: Int = checkNotNull(savedStateHandle.get<Int>(ID_ARG))

   companion object {
      const val ID_ARG = "movie_id"
   }
}