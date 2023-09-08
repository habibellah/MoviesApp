package com.example.moviesapp.home_feature.domain.model

import com.example.moviesapp.search_feature.domain.model.util.MediaType

data class Movie(
   val movieId : Int,
   val movieName : String,
   val image : String,
   val rate : String,
   val movieGene : String,
   val mediaType : MediaType = MediaType.Movie
){
   fun toMedia() : Media{
      return Media(
         mediaId = movieId , mediaName = movieName , image = image , rate = rate , mediaGene = movieGene , mediaType =mediaType
      )
   }
}