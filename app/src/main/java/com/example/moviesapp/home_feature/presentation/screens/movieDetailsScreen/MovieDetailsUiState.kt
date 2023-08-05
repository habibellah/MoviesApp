package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import com.example.moviesapp.home_feature.domain.model.Actor
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.MovieDetails
import com.example.moviesapp.home_feature.domain.model.Review

data class MovieDetailsUiState(
   val movieDetails : MovieDetails? = null ,
   val actorList : List<Actor> = listOf() ,
   val reviewList : List<Review> = listOf(),
   val similarMovieList : List<Movie> = listOf()
)