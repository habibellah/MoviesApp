package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.seeAllScreen.SeeAllScreen

private const val ROUTE = "seeAllScreen"

fun NavGraphBuilder.seeAllScreenRoute() {
   composable(ROUTE
   ) {
      SeeAllScreen()
   }
}
