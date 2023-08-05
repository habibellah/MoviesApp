package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.useCase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
   private val getMovieDetailsUseCase : GetMovieDetailsUseCase
): ViewModel(){

  private val _movieDetailsUiState : MutableStateFlow<MovieDetailsUiState> = MutableStateFlow(MovieDetailsUiState())
  val movieDetailsUiState : StateFlow<MovieDetailsUiState> = _movieDetailsUiState

   init {
      getMovieDetailsBy(12)
   }

   private fun getMovieDetailsBy(id : Int) {
      viewModelScope.launch {

      }
   }
}