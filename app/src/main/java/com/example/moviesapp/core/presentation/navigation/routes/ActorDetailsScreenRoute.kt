package com.example.moviesapp.core.presentation.navigation.routes

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.core.presentation.navigation.routes.ActorDetailsArgs.Companion.ID_ARG
import com.example.moviesapp.home_feature.presentation.screens.actorDetailsScreen.ActorDetailsScreen

private const val ROUTE = "actorDetailsScreen"

fun NavController.navigateToActorDetailsScreen(actorId : Int) {
   navigate("$ROUTE/$actorId")
}

fun NavGraphBuilder.actorDetailsScreenRoute() {
   composable("$ROUTE/{$ID_ARG}",
      arguments = listOf(
         navArgument(ID_ARG){
            type = NavType.IntType
            defaultValue = 0
         }
      )
   ) {
      ActorDetailsScreen()
   }
}

class ActorDetailsArgs(savedStateHandle: SavedStateHandle) {
   val id: Int = checkNotNull(savedStateHandle.get<Int>(ID_ARG))

   companion object {
      const val ID_ARG = "actor_id"
   }
}