package com.example.moviesapp.profile_feature.presentation.screens.watchHistoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun WatchHistoryScreen() {
   WatchHistoryContent(
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
         1 ,
      )
   )
}

@Composable
private fun WatchHistoryContent(watchHistoryList : List<Int>) {
   LazyColumn (
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
           ){
      items(watchHistoryList) {
         WatchHistoryItem()
      }
   }
}
