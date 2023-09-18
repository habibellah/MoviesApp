package com.example.moviesapp.search_feature.domain.model

import com.example.moviesapp.search_feature.domain.model.util.MediaType

class MediaSearch(
    val image : String,
    val mediaType : MediaType,
    val mediaId : Int
)