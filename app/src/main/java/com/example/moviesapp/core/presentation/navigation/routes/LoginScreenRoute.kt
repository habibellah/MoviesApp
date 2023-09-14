package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.profile_feature.presentation.screens.loginScreen.LoginScreen

private const val ROUTE = "loginScreen"

fun NavGraphBuilder.loginScreenRoute() {
   composable(ROUTE
   ) {
      LoginScreen()
   }
}
