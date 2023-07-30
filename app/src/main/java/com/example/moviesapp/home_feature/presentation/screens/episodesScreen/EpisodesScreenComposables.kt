package com.example.moviesapp.home_feature.presentation.screens.episodesScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage

@Composable
fun EpisodeItem(){
   Column(modifier = Modifier.fillMaxWidth()) {
      Row {
         CoilImage(imageUrl = "https://www.treehugger.com/thmb/nSp8ESJ1N6zq_bsTVL_MoSrKAqA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1273584292-cbcd5f85f4c646d58f7a7fa158dcaaeb.jpg",
         modifier = Modifier
            .width(80.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp)))
         Column {
            Text(text = "Pilot")
            Row {
               Icon(imageVector = Icons.Default.Star , contentDescription = null)
               Text(text = "7.151")
               Text(text = "(200review)")
            }
         }
         Column {
            Text(text = "22 minutes")
            Text(text = "2013-12-02")
         }
      }
      Text(text = "Description")
   }
}