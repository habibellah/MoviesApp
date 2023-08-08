package com.example.moviesapp.home_feature.domain.model

data class TvShowDetails(
   val tvShowName : String ,
   val tvShowId : Int ,
   val image : String,
   val releaseDate : String ,
   val genre : String,
   val rate : String,
   val overView : String,
   val reviewCount : String,
   val season : List<Season>
)