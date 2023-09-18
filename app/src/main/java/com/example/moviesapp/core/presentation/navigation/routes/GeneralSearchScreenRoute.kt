package com.example.moviesapp.core.presentation.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviesapp.search_feature.presentation.screens.generalSearchScreen.GeneralSearchScreen

private const val ROUTE = "generalSearchScreen"

fun NavController.navigateToGeneralSearchScreen(){
   navigate(ROUTE)
}
fun NavGraphBuilder.generalSearchScreenRoute(navController : NavController) {
   composable(ROUTE
   ) {
      GeneralSearchScreen(navController = navController)
   }
}
