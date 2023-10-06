package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.profile_feature.presentation.screens.loginScreen.LoginScreen

private const val ROUTE = "loginScreen"

fun NavController.navigateToLoginScreen(){
   navigate(ROUTE)
}
fun NavGraphBuilder.loginScreenRoute(navController : NavController) {
   composable(ROUTE
   ) {
      LoginScreen(navController = navController)
   }
}
