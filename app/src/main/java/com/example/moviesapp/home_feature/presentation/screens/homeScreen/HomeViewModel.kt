package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetAiringTodayTvShowUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetPopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val getPopularMovieUseCase : GetPopularMovieUseCase,
   private val getAiringTodayTvShowUseCase : GetAiringTodayTvShowUseCase) : ViewModel() {

   private val _homeUiState : MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
   val homeUiState : StateFlow<HomeUiState> = _homeUiState

   init {
      getPopularMovieList()
      getAiringTodayTvShowList()
   }

   private fun getAiringTodayTvShowList() {
      viewModelScope.launch {
         getAiringTodayTvShowUseCase.getAiringTodayTvShowList().collect{ airingTodayState ->
            when(airingTodayState){
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(airingTodayTvShow = homeUiState.airingTodayTvShow.copy(error = true)) }
               }
               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->homeUiState.copy(airingTodayTvShow = homeUiState.airingTodayTvShow.copy(loading = true)) }
               }
               is MovieState.Success -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(airingTodayTvShow = homeUiState.airingTodayTvShow.copy(loading = false, error = false, airingTodayTvShowList = airingTodayState.data)) }
               }
            }

         }
      }
   }

   private fun getPopularMovieList() {
      viewModelScope.launch {
         getPopularMovieUseCase.getPopularMovieList().collect{ popularMovieState ->
            when(popularMovieState){
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(popularMovie = homeUiState.popularMovie.copy(error = true)) }
               }
               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->homeUiState.copy(popularMovie = homeUiState.popularMovie.copy(loading = true)) }
               }
               is MovieState.Success -> {
                  _homeUiState.update { homeUiState -> homeUiState.copy(popularMovie = homeUiState.popularMovie.copy(loading = false, error = false, popularMovieList = popularMovieState.data)) }
               }
            }
         }
      }
   }
}