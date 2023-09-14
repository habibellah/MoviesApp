package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.search_feature.presentation.screens.tvShowSearchScreen.TvShowSearchScreen

private const val ROUTE = "tvShowSearchScreen"

fun NavController.navigateToTvShowSearchScreen(){
   navigate(ROUTE)
}
fun NavGraphBuilder.tvShowSearchScreenRoute() {
   composable(ROUTE
   ) {
      TvShowSearchScreen()
   }
}
