package com.example.moviesapp.home_feature.domain.model

import com.example.moviesapp.search_feature.domain.model.util.MediaType

data class TvShow(
   val tvShowId : Int,
   val tvShowName : String,
   val image : String,
   val mediaType : MediaType = MediaType.TvShow
){
   fun toMedia() : Media{
      return Media(
         mediaId = tvShowId , mediaName = tvShowName , image = image , rate = "0.0" , mediaGene = "non" , mediaType = mediaType
      )
   }
}