package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.profile_feature.presentation.screens.watchHistoryScreen.WatchHistoryScreen

private const val ROUTE = "watchHistoryScreen"

fun NavGraphBuilder.watchHistoryScreenRoute() {
   composable(ROUTE
   ) {
      WatchHistoryScreen()
   }
}
