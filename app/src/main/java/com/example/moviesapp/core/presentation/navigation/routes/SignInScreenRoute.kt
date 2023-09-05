package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.home_feature.presentation.screens.episodesScreen.EpisodesScreen
import com.example.moviesapp.profile_feature.presentation.screens.signInScreen.SignInScreen

private const val ROUTE = "signInScreen"

fun NavGraphBuilder.signInScreenRoute() {
   composable(ROUTE
   ) {
      SignInScreen()
   }
}
