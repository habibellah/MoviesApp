package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.episodesScreen.EpisodesScreen

private const val ROUTE = "episodesScreen"

fun NavGraphBuilder.episodesScreenRoute() {
   composable(ROUTE
   ) {
      EpisodesScreen()
   }
}
