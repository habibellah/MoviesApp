package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen.TvShowDetailsScreen

private const val ROUTE = "tvShowDetailsScreen"

fun NavGraphBuilder.tvShowDetailsScreenRoute() {
   composable(ROUTE
   ) {
      TvShowDetailsScreen()
   }
}
