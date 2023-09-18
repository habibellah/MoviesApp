package com.example.moviesapp.search_feature.presentation.screens.generalSearchScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.moviesapp.R
import com.example.moviesapp.core.presentation.CoilImage
import com.example.moviesapp.search_feature.domain.model.MediaSearch
import com.example.moviesapp.search_feature.domain.model.util.MediaType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralScreenHeader(onSearchMedia : (String , String) -> Unit) {
   var queryState by remember {
      mutableStateOf("")
   }
   var mediaTypeState by remember {
      mutableStateOf("")
   }
   var selectedChipState by remember {
      mutableStateOf("")
   }
   TextField(value = queryState , onValueChange = {
      queryState = it
      onSearchMedia(queryState , mediaTypeState)
   })

   Row {
      getAllSearchCategory().forEach {
         AssistChip(onClick = {
            mediaTypeState = it.mediaType
            selectedChipState = it.categoryName
            onSearchMedia(queryState , mediaTypeState)
         } ,
            label = { Text(text = it.categoryName, color = if(selectedChipState == it.categoryName){
               colorResource(id = R.color.red)}else{ colorResource(id = R.color.white)}) })
      }
   }
}

@Composable
fun GeneralSearchBody(searchList : List<MediaSearch>,onMediaItemClick:(mediaType : MediaType,mediaId : Int)->Unit) {
   LazyVerticalGrid(
      columns = GridCells.Fixed(2) ,
      verticalArrangement = Arrangement.spacedBy(16.dp) ,
      horizontalArrangement = Arrangement.spacedBy(16.dp) ,
      contentPadding = PaddingValues(16.dp)
   ) {
      items(searchList) {
         CoilImage(
            imageUrl = it.image ,
            modifier = Modifier
               .clickable { onMediaItemClick(it.mediaType,it.mediaId) }
               .height(140.dp)
               .width(80.dp)
               .clip(
                  RoundedCornerShape(10.dp)
               )
         )
      }
   }
}

enum class SearchCategory(val categoryName : String , val mediaType : String) {
   Actor(categoryName = "actor" , mediaType = "Actor") , Movie(
      categoryName = "movie" ,
      mediaType = "Movie"
   ) ,
   TvShow(categoryName = "tvShow" , mediaType = "TvShow")
}

fun getAllSearchCategory() : List<SearchCategory> {
   return listOf(
      SearchCategory.Actor ,
      SearchCategory.TvShow ,
      SearchCategory.Movie
   )
}