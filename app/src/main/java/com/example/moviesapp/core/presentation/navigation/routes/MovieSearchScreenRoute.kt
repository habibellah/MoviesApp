package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen.MovieSearchScreen

private const val ROUTE = "movieSearchScreen"

fun NavController.navigateToMovieSearchScreen(){
   navigate(ROUTE)
}
fun NavGraphBuilder.movieSearchScreenRoute() {
   composable(ROUTE
   ) {
      MovieSearchScreen()
   }
}
