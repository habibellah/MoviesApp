package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetPopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPopularMovieUseCase : GetPopularMovieUseCase) : ViewModel() {

   private val _homeUiState : MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
   val homeUiState : StateFlow<HomeUiState> = _homeUiState

   init {
      getPopularMovieList()
   }

   private fun getPopularMovieList() {
      viewModelScope.launch {
         getPopularMovieUseCase.getPopularMovieList().collect{ popularMovieState ->
            when(popularMovieState){
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(error = true) }
               }
               MovieState.Loading -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(loading = true) }
               }
               is MovieState.Success -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(error = false, loading = false, popularMovieList = popularMovieState.data) }
               }
            }
         }
      }
   }
}