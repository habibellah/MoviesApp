package com.example.moviesapp.core.presentation.navigation.routes

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.home_feature.presentation.screens.seeAllScreen.SeeAllScreen
import com.example.moviesapp.search_feature.domain.model.util.MediaType

private const val ROUTE = "seeAllScreen"

fun NavController.navigateToSeeAllScreen(mediaType : MediaType,mediaCategory : String){
   navigate("$ROUTE/$mediaType/$mediaCategory")
}
fun NavGraphBuilder.seeAllScreenRoute() {
   composable("$ROUTE/{${SeeAllScreenArgs.MEDIA_TYPE}}/{${SeeAllScreenArgs.MEDIA_CATEGORY}}",
      arguments = listOf(
         navArgument(SeeAllScreenArgs.MEDIA_TYPE){
            NavType.EnumType::class.java
            defaultValue = MediaType.Movie
         },
         navArgument(SeeAllScreenArgs.MEDIA_CATEGORY){
            NavType.StringType
            defaultValue = "default"
         }
      ) ,
      enterTransition = {
         fadeIn(
            animationSpec = tween(
               500, easing = LinearEasing
            )
         ) + slideIntoContainer(
            animationSpec = tween(500, easing = EaseIn),
            towards = AnimatedContentTransitionScope.SlideDirection.Start
         )

      },
      exitTransition = {
         fadeOut(
            animationSpec = tween(
               200, easing = LinearEasing
            )
         ) + slideOutOfContainer(
            animationSpec = tween(200, easing = EaseOut),
            towards = AnimatedContentTransitionScope.SlideDirection.End
         )

      }
   ) {
      SeeAllScreen()
   }
}

class SeeAllScreenArgs(savedStateHandle : SavedStateHandle){
   val mediaType : MediaType = checkNotNull(savedStateHandle[MEDIA_TYPE])
   val mediaCategory : String = checkNotNull(savedStateHandle[MEDIA_CATEGORY])
   companion object{
      const val MEDIA_TYPE = "movie_or_tvshow"
      const val MEDIA_CATEGORY = "media_category"
   }
}
