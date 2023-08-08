package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.home_feature.presentation.screens.episodesScreen.EpisodesScreen
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.HomeScreen
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.HeaderMovieDetails
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.MovieDetailsScreen
import com.example.moviesapp.home_feature.presentation.screens.seeAllScreen.SeeAllScreen
import com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen.TvShowDetailsScreen
import com.example.moviesapp.profile_feature.presentation.screens.loginScreen.LoginScreen
import com.example.moviesapp.profile_feature.presentation.screens.profileScreen.ProfileScreen
import com.example.moviesapp.profile_feature.presentation.screens.watchHistoryScreen.WatchHistoryScreen
import com.example.moviesapp.search_feature.presentation.screens.exploreScreen.ExploreScreen
import com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen.MovieSearchScreen
import com.example.moviesapp.search_feature.presentation.screens.tvShowSearchScreen.TvShowSearchScreen
import com.example.moviesapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState : Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         MoviesAppTheme {
            // A surface container using the 'background' color from the theme
            Surface(
               modifier = Modifier.fillMaxSize() ,
               color = MaterialTheme.colorScheme.background
            ) {
              TvShowDetailsScreen()
            }
         }
      }
   }
}
