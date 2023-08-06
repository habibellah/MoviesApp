package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.ActorItem
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.RatingBar
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.ReviewItem

@Composable
fun HeaderTvShowDetails() {
   Box(contentAlignment = Alignment.BottomCenter) {
      CoilImage(
         imageUrl = "https://www.treehugger.com/thmb/nSp8ESJ1N6zq_bsTVL_MoSrKAqA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1273584292-cbcd5f85f4c646d58f7a7fa158dcaaeb.jpg" ,
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
      )
      Column (
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp),
         verticalArrangement = Arrangement.SpaceBetween,
         horizontalAlignment = Alignment.CenterHorizontally
      ){
         Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
         ) {
            Icon(imageVector = Icons.Default.ArrowBack , contentDescription = null)
            Icon(imageVector = Icons.Default.Create , contentDescription = null)
         }
         Button(onClick = { /*TODO*/ }) {
            Row {
               Icon(imageVector = Icons.Default.PlayArrow , contentDescription = null)
               Text(text = "Play Trailler")
            }
         }
      }
   }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TvShowDetailsBody(
   castList : List<String>,
   reviewList : List<String>
){
   Column (horizontalAlignment = Alignment.CenterHorizontally){
      Text(text = "Avater: The Way of water")
      Row {
         Text(text ="14/12/2022 /")
         Text(text ="3h12m")
      }
      Text(text ="Science Fiction,Adventure,Action")
      Row {
         Icon(imageVector = Icons.Default.Star , contentDescription = null)
         Text(text ="7.7")
         Text(text = "(1920reviews)")
      }
      Text(text = "Overview",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      Text(text = "the content of the overview fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
      Text(text = "Cast",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
         items(castList){
            ActorItem(imageUrl = it , castName = "hi")
         }
      }
      Text(text = "Seasons",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
         items(reviewList){
           SeasonItem(it)

         }
      }
      Text(text = "Rate The Movie",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      RatingBar(rating = 5 , isSelectable = false)
      Text(text = "Reviews",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow{
         items(reviewList){
            ReviewItem("","","")
         }
      }
   }
}

@Composable
fun SeasonItem(imageUrl : String) {
   Row (modifier = Modifier.fillMaxWidth()){
      CoilImage(imageUrl = imageUrl,
         modifier = Modifier
            .height(150.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(10.dp)))
      Column (modifier = Modifier.height(200.dp), verticalArrangement = Arrangement.SpaceAround){
         Row (horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Specials")
            Text(text = "2016-5-21")
         }
         Text(text = "ThisSeason has no description")
      }
   }
}
