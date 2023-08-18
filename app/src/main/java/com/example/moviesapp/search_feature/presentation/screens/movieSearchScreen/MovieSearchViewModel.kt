package com.example.moviesapp.search_feature.presentation.screens.movieSearchScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.search_feature.domain.useCase.SearchMovieListByGenresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
   private val searchMovieListByGenresUseCase : SearchMovieListByGenresUseCase
): ViewModel() {

   private val _movieSearchUiState : MutableStateFlow<MovieSearchUiState> = MutableStateFlow(MovieSearchUiState())
   val movieSearchUiState : StateFlow<MovieSearchUiState> = _movieSearchUiState.asStateFlow()

   init {
   getMovieListBy(null)
   }

   fun getMovieListBy(genres : Int?){
      _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(movieList = emptyList()) }
      viewModelScope.launch {
         searchMovieListByGenresUseCase.searchMovieListBy(genres).collect{ movieSearchState ->
            when(movieSearchState){
               is MovieState.Error -> {
                  _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(error = true) }
               }
               MovieState.Loading -> {
                  _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(loading = true) }
               }
               is MovieState.Success -> {
                  _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(movieList = movieSearchState.data, error = false,loading = false) }
               }
            }
         }
      }
   }
}