package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.profile_feature.presentation.screens.profileScreen.ProfileScreen

private const val ROUTE = "profileScreen"


  fun NavController.navigateToProfileScreen(){
     navigate(ROUTE)
  }
fun NavGraphBuilder.profileScreenRoute(navController : NavController) {
   composable(ROUTE) {
      ProfileScreen(navController = navController)
   }
}
