package com.example.moviesapp.home_feature.presentation.screens.actorDetailsScreen

import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.core.presentation.CoilImage
import com.example.moviesapp.home_feature.domain.model.ActorMovies
import com.example.moviesapp.home_feature.domain.model.Movie

@Composable
fun ActorDetailsHeader(imageUrl : String , actorName : String) {
   Box(contentAlignment = Alignment.BottomCenter) {
      CoilImage(
         imageUrl = imageUrl ,
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
      )
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp) ,
         verticalArrangement = Arrangement.SpaceBetween ,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start
         ) {
            Icon(imageVector = Icons.Default.ArrowBack , contentDescription = null)
         }
         Text(text = actorName , fontSize = 20.sp)
      }
   }
}

@Composable
fun ActorDetailsBody(movieList : List<ActorMovies> , biography : String,gender : String,birthday : String,placeOfBirth : String,knownFor : String) {
   Column (
      modifier = Modifier.fillMaxWidth()
         .verticalScroll(rememberScrollState())
           ){
      Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
         Column {
            Text(text = "Gender")
            Text(text = gender)
         }
         Column {
            Text(text = "Birthday")
            Text(text = birthday)
         }
      }
      Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
         Column {
            Text(text = "place of birth")
            Text(text = placeOfBirth)
         }
         Column {
            Text(text = "knownFor")
            Text(text = knownFor)
         }
      }
      Text(
         text = "Movies" ,
         modifier = Modifier.fillMaxWidth() ,
         textAlign = TextAlign.Start
      )
      LazyRow (contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)){
         items(movieList) {
            CoilImage(
               imageUrl = it.image , modifier =
               Modifier
                  .height(200.dp)
                  .width(100.dp)
            )
         }
      }
      Text(
         text = "Biography" ,
         modifier = Modifier.fillMaxWidth() ,
         textAlign = TextAlign.Start
      )
      Text(text = biography)
   }
}