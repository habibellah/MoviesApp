package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetTvShowDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
   private val getTvShowDetailsUseCase : GetTvShowDetailsUseCase
): ViewModel() {

   private val _tvShowDetailsUiState = MutableStateFlow(TvShowDetailsUiState())
   val tvShowDetailsUiState : StateFlow<TvShowDetailsUiState> = _tvShowDetailsUiState

   init {
      getTvShowDetailsBy(12)
   }

   private fun getTvShowDetailsBy(id : Int) {
      viewModelScope.launch {
         getTvShowDetailsUseCase.getTvShowDetailsBy(id).collect{ tvShowDetailsState ->
            when(tvShowDetailsState){
               is MovieState.Error -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(error = true) }
               }
               MovieState.Loading -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(loading = true) }
               }
               is MovieState.Success -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowDetails = tvShowDetailsState.data) }
               }
            }
         }
      }
   }
}