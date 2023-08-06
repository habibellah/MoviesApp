package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetMovieActorsUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetMovieDetailsUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetMovieReviewUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetSimilarMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
   private val getMovieDetailsUseCase : GetMovieDetailsUseCase,
   private val getMovieActorsUseCase : GetMovieActorsUseCase,
   private val getMovieReviewUseCase : GetMovieReviewUseCase,
   private val getSimilarMovieUseCase : GetSimilarMovieUseCase
) : ViewModel() {
   private val _movieDetailsUiState : MutableStateFlow<MovieDetailsUiState> =
      MutableStateFlow(MovieDetailsUiState())
   val movieDetailsUiState : StateFlow<MovieDetailsUiState> = _movieDetailsUiState

   init {
      getMovieDetailsBy(12)
      getSimilarMoviesBy(12)
      getReviewListBy(12)
      getMovieActorListBy(12)
   }

   private fun getMovieActorListBy(id : Int) {
      viewModelScope.launch {
         getMovieActorsUseCase.getMovieActorListBy(id).collect { movieActorState ->
            when (movieActorState) {
               is MovieState.Error -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        actorState = movieDetailsUiState.actorState.copy(error = true)
                     )
                  }
               }

               MovieState.Loading -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        actorState = movieDetailsUiState.actorState.copy(loading = true)
                     )
                  }
               }

               is MovieState.Success -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        actorState = movieDetailsUiState.actorState.copy(
                           error = false , loading = false , actorList = movieActorState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getReviewListBy(id : Int) {
      viewModelScope.launch {
         getMovieReviewUseCase.getMovieReviewListBy(id).collect { movieReviewState ->
            when (movieReviewState) {
               is MovieState.Error -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        movieReviewState = movieDetailsUiState.movieReviewState.copy(error = true)
                     )
                  }
               }

               MovieState.Loading -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        movieReviewState = movieDetailsUiState.movieReviewState.copy(loading = true)
                     )
                  }
               }

               is MovieState.Success -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        movieReviewState = movieDetailsUiState.movieReviewState.copy(
                           error = false , loading = false , reviewList = movieReviewState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getSimilarMoviesBy(id : Int) {
      viewModelScope.launch {
         getSimilarMovieUseCase.getSimilarMovieBy(id).collect { similarMovieState ->
            when (similarMovieState) {
               is MovieState.Error -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        similarMovieState = movieDetailsUiState.similarMovieState.copy(error = true)
                     )
                  }
               }

               MovieState.Loading -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        similarMovieState = movieDetailsUiState.similarMovieState.copy(loading = true)
                     )
                  }
               }

               is MovieState.Success -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        similarMovieState = movieDetailsUiState.similarMovieState.copy(
                           error = false , loading = false , similarMovieList = similarMovieState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getMovieDetailsBy(id : Int) {
      viewModelScope.launch {
         getMovieDetailsUseCase.getMovieDetailsBy(id).collect { movieDetailsState ->
            when (movieDetailsState) {
               is MovieState.Error -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        movieDetailsState = movieDetailsUiState.movieDetailsState.copy(error = true)
                     )
                  }
               }

               MovieState.Loading -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        movieDetailsState = movieDetailsUiState.movieDetailsState.copy(loading = true)
                     )
                  }
               }

               is MovieState.Success -> {
                  _movieDetailsUiState.update { movieDetailsUiState ->
                     movieDetailsUiState.copy(
                        movieDetailsState = movieDetailsUiState.movieDetailsState.copy(
                           error = false , loading = false , movieDetails = movieDetailsState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }
}