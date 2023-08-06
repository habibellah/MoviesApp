package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import com.example.moviesapp.home_feature.domain.model.Actor
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.MovieDetails
import com.example.moviesapp.home_feature.domain.model.Review

data class MovieDetailsUiState(
   val movieDetailsState : MovieDetailsState = MovieDetailsState() ,
   val actorState : ActorState = ActorState() ,
  val movieReviewState : MovieReviewState  = MovieReviewState() ,
   val similarMovieState : SimilarMovieState = SimilarMovieState()
)

data class MovieDetailsState(
   val movieDetails : MovieDetails? = null ,
   val loading : Boolean = false ,
   val error : Boolean = false
)

data class ActorState(
   val actorList : List<Actor> = listOf(),
   val loading : Boolean = false ,
   val error : Boolean = false
)

data class SimilarMovieState(
   val similarMovieList : List<Movie> = listOf(),
   val loading : Boolean = false ,
   val error : Boolean = false
)

data class MovieReviewState(
   val reviewList : List<Review> = listOf(),
   val loading : Boolean = false ,
   val error : Boolean = false
)