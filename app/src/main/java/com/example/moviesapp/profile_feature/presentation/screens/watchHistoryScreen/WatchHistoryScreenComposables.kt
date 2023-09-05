package com.example.moviesapp.profile_feature.presentation.screens.watchHistoryScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesapp.core.presentation.CoilImage

@Composable
fun WatchHistoryItem() {
   Row {
      CoilImage(
         imageUrl = "https://www.treehugger.com/thmb/nSp8ESJ1N6zq_bsTVL_MoSrKAqA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1273584292-cbcd5f85f4c646d58f7a7fa158dcaaeb.jpg" ,
         modifier = Modifier
            .height(100.dp)
            .width(150.dp)
      )
      Column(
         modifier = Modifier
            .height(100.dp)
            .width(150.dp)
      ) {
         Text(text = "The Chrociles of narinia the lion")
         Row {
            Icon(imageVector = Icons.Default.Star , contentDescription = null)
            Text(text = "7.1")
         }
      }
      Column(
         modifier = Modifier
            .height(100.dp)
            .width(150.dp)
      ) {
         Text(text = "2h23m")
         Text(text = "07/12/2002")
      }
   }
}