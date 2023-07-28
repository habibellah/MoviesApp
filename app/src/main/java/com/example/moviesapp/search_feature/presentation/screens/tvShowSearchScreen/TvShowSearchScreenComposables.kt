package com.example.moviesapp.search_feature.presentation.screens.tvShowSearchScreen

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage

@Composable
fun TvShowSearchScreenHeader(){
   TvShowCategoryChips{

   }
}

@Composable
fun TvShowSearchScreenBody(tvShowList : List<String>){
   LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      contentPadding = PaddingValues(16.dp)
   ){
      items(tvShowList){
         CoilImage(imageUrl = it,
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
fun TvShowCategoryChips(
   onSearchCategoryClick : () -> Unit
) {
   Row(
      modifier = Modifier
         .fillMaxWidth()
         .horizontalScroll(rememberScrollState()),
      horizontalArrangement = Arrangement.spacedBy(3.dp)
   ) {
      getAllTvShowCategories().forEach {
         AssistChip(onClick = { onSearchCategoryClick() }, label = { Text(text = it.category)})
      }
   }
}

enum class TvShowCategories(val category : String, val id : Int?) {
   All(category = "all",null),
   ActionAndAdventure(category = "Action & Adventure",10759),
   Animation(category = "Animation",16),
   Comedy(category = "Comedy",35),
   Crime(category = "Crime",80),
   Documentary(category = "Documentary",99),
   Drama(category = "Drama",18),
   Family(category = "Family",10751),
   Kids(category = "Kids",10762),
   Mystery(category = "Mystery",9648),
   News(category = "News",10763),
   Reality(category = "Reality",10764),
   SciFiAndFantasy(category = "Sci-Fi & Fantasy",10765),
   Soap(category = "Soap",10766),
   Talk(category = "Talk",10767),
   WarAndPolitics(category = "War & Politics",10768),
   Western(category = "Western",37),
}

fun getAllTvShowCategories() : List<TvShowCategories> {
   return listOf(
      TvShowCategories.All,
      TvShowCategories.ActionAndAdventure,
      TvShowCategories.Animation,
      TvShowCategories.Comedy,
      TvShowCategories.Crime,
      TvShowCategories.Documentary,
      TvShowCategories.Drama,
      TvShowCategories.Family,
      TvShowCategories.Kids,
      TvShowCategories.Mystery,
      TvShowCategories.News,
      TvShowCategories.Reality,
      TvShowCategories.SciFiAndFantasy,
      TvShowCategories.Soap,
      TvShowCategories.Talk,
      TvShowCategories.WarAndPolitics,
      TvShowCategories.Western,
   )
}