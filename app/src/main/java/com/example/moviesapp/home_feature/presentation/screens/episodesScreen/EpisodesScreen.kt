package com.example.moviesapp.home_feature.presentation.screens.episodesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun EpisodesScreen() {
   EpisodesScreenContent(
      listOf(
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
         1 ,
      )
   )
}

@Composable
fun EpisodesScreenContent(episodeList : List<Int>) {
   LazyColumn (
      contentPadding = PaddingValues(16.dp)    ,
      verticalArrangement = Arrangement.spacedBy(16.dp)
   ){
      items(episodeList) {
         EpisodeItem()
      }
   }
}
