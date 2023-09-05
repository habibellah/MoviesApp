package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.episodesScreen.EpisodesScreen
import com.example.moviesapp.profile_feature.presentation.screens.profileScreen.ProfileScreen

private const val ROUTE = "profileScreen"

fun NavGraphBuilder.profileScreenRoute() {
   composable(ROUTE
   ) {
      ProfileScreen()
   }
}
