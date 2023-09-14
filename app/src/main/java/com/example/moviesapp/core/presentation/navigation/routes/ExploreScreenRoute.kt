package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.search_feature.presentation.screens.exploreScreen.ExploreScreen

private const val ROUTE = "exploreScreen"

fun NavGraphBuilder.exploreScreenRoute(navController : NavController) {
   composable(ROUTE
   ) {
      ExploreScreen(navController = navController)
   }
}
