package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.episodesScreen.EpisodesScreen
import com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen.MovieSearchScreen

private const val ROUTE = "movieSearchScreen"

fun NavGraphBuilder.movieSearchScreenRoute() {
   composable(ROUTE
   ) {
      MovieSearchScreen()
   }
}
