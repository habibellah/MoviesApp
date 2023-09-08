package com.example.moviesapp.home_feature.domain.model

import com.example.moviesapp.search_feature.domain.model.util.MediaType

data class Media (
   val mediaId : Int,
   val mediaName : String,
   val image : String,
   val rate : String,
   val mediaGene : String,
   val mediaType : MediaType
)