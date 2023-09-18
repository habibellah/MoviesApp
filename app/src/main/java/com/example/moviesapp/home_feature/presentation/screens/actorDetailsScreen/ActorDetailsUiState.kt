package com.example.moviesapp.home_feature.presentation.screens.actorDetailsScreen

import com.example.moviesapp.home_feature.domain.model.ActorDetails

data class ActorDetailsUiState(
   val actorInfo : ActorInfo = ActorInfo(),
   val actorMovies : ActorMovies = ActorMovies()
)

data class ActorInfo(
   val actorDetails : ActorDetails? = null,
   val error : Boolean = false,
   val loading : Boolean = false
)

data class ActorMovies(
   val actorMovies : List<com.example.moviesapp.home_feature.domain.model.ActorMovies> = listOf(),
   val error : Boolean = false,
   val loading : Boolean = false
)