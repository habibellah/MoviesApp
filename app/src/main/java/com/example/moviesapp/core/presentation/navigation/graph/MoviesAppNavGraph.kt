package com.example.moviesapp.core.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.moviesapp.core.presentation.navigation.routes.episodesScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.exploreScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.generalSearchScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.homeScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.loginScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.movieDetailsScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.movieSearchScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.profileScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.seeAllScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.signInScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.tvShowDetailsScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.tvShowSearchScreenRoute
import com.example.moviesapp.core.presentation.navigation.routes.watchHistoryScreenRoute

@Composable
fun MoviesAppNavGraph(navController : NavHostController , startDestination : String) {
   NavHost(navController = navController, startDestination = startDestination) {
      episodesScreenRoute()
      exploreScreenRoute()
      generalSearchScreenRoute()
      homeScreenRoute(navController)
      loginScreenRoute()
      movieDetailsScreenRoute()
      movieSearchScreenRoute()
      profileScreenRoute()
      seeAllScreenRoute()
      signInScreenRoute()
      tvShowDetailsScreenRoute()
      tvShowSearchScreenRoute()
      watchHistoryScreenRoute()
   }
}