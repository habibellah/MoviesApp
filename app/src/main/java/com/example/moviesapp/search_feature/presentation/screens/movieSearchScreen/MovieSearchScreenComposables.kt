package com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
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
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.core.presentation.CoilImage

@Composable
fun HeaderMovieSearchScreen(onSearchCategoryClick : (Int?) -> Unit){
   MovieCategoryChips {
      onSearchCategoryClick(it)
   }
}

@Composable
fun MovieSearchScreenBody(movieList : List<Movie>){
   LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
   verticalArrangement = Arrangement.spacedBy(16.dp),
   horizontalArrangement = Arrangement.spacedBy(16.dp),
   contentPadding = PaddingValues(16.dp)
   ){
      items(movieList){
         CoilImage(imageUrl = it.image,
            modifier = Modifier
               .height(100.dp)
               .width(80.dp)
               .clip(RoundedCornerShape(10.dp))
         )
      }
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCategoryChips(
   onSearchCategoryClick : (Int?) -> Unit
) {
   var chipColorState by remember{
      mutableStateOf("all")
   }
   Row(
      modifier = Modifier
         .fillMaxWidth()
         .horizontalScroll(rememberScrollState()),
      horizontalArrangement = Arrangement.spacedBy(3.dp)
   ) {
      getAllMovieCategories().forEach {
         AssistChip(onClick = { onSearchCategoryClick(it.id)
                              chipColorState = it.category
                              }, label = { Text(text = it.category, color = if(chipColorState == it.category){
            colorResource(id = R.color.red)
         }else{
            colorResource(id = R.color.white)
         })})
      }
   }
}

enum class MovieCategories(val category : String, val id : Int?) {
   All(category = "all",null),
   Action(category = "action",28),
   Adventure(category = "Adventure",12),
   Animation(category = "Animation",16),
   Comedy(category = "Comedy",35),
   Crime(category = "Crime",80),
   Documentary(category = "Documentary",99),
   Drama(category = "Drama",18),
   Family(category = "Family",10751),
   Fantasy(category = "Fantasy",14),
   History(category = "History",36),
   Horror(category = "Horror",27),
   Music(category = "Music",10402),
   Mystery(category = "Mystery",9648),
   Romance(category = "Romance",10749),
   ScienceFiction(category = "Science Fiction",878),
   TVMovie(category = "TV Movie",10770),
   Thriller(category = "Thriller",53),
   War(category = "War",10752),
   Western(category = "Western",37),
}

fun getAllMovieCategories() : List<MovieCategories> {
   return listOf(
      MovieCategories.All,
      MovieCategories.Action,
      MovieCategories.Adventure,
      MovieCategories.Animation,
      MovieCategories.Comedy,
      MovieCategories.Crime,
      MovieCategories.Documentary,
      MovieCategories.Drama,
      MovieCategories.Family,
      MovieCategories.Fantasy,
      MovieCategories.History,
      MovieCategories.Horror,
      MovieCategories.Music,
      MovieCategories.Mystery,
      MovieCategories.Romance,
      MovieCategories.ScienceFiction,
      MovieCategories.TVMovie,
      MovieCategories.Thriller,
      MovieCategories.War,
      MovieCategories.Western,
   )
}