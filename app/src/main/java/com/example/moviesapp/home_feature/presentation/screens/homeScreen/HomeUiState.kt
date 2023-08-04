package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.TvShow

data class HomeUiState(
   val popularMovie : PopularMovie = PopularMovie() ,
  val airingTodayTvShow : AiringTodayTvShow = AiringTodayTvShow()
)

data class PopularMovie(
   val popularMovieList : List<Movie> = listOf() ,
   val loading : Boolean = false ,
   val error : Boolean = false
)

data class AiringTodayTvShow(
   val airingTodayTvShowList : List<TvShow> = listOf() ,
   val loading : Boolean = false ,
   val error : Boolean = false
)