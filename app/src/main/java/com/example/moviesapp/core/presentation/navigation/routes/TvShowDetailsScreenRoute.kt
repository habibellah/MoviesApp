package com.example.moviesapp.core.presentation.navigation.routes

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.core.presentation.navigation.routes.TvShowDetailsArgs.Companion.TV_SHOW_ID
import com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen.TvShowDetailsScreen

private const val ROUTE = "tvShowDetailsScreen"


fun NavController.navigateToTvShowDetailsScreen(tvShowId : Int){
   navigate("$ROUTE/$tvShowId")
}

fun NavGraphBuilder.tvShowDetailsScreenRoute() {
   composable("$ROUTE/{$TV_SHOW_ID}",
      arguments = listOf(
         navArgument(TV_SHOW_ID){
            type = NavType.IntType
            defaultValue = 0
         }
      )
   ) {
      TvShowDetailsScreen()
   }
}

class TvShowDetailsArgs(savedStateHandle : SavedStateHandle){
   val id: Int = checkNotNull(savedStateHandle.get<Int>(TV_SHOW_ID))
   companion object{
      const val TV_SHOW_ID = "tv_show_id"
   }
}