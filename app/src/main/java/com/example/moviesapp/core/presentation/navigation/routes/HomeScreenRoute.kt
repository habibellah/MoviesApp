package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.HomeScreen

private const val ROUTE = "homeScreen"

fun NavGraphBuilder.homeScreenRoute(navController : NavController) {
   composable(
      ROUTE
   ) {
      HomeScreen(navController = navController)
   }
}
