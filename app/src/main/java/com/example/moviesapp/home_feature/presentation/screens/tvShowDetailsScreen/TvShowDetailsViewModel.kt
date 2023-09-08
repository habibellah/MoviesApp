package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.presentation.navigation.routes.TvShowDetailsArgs
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetTvShowDetailsUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetTvShowReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
   private val getTvShowDetailsUseCase : GetTvShowDetailsUseCase,
   private val getTvShowReviewUseCase : GetTvShowReviewUseCase,
   savedStateHandle : SavedStateHandle
): ViewModel() {

   private val _tvShowDetailsUiState = MutableStateFlow(TvShowDetailsUiState())
   val tvShowDetailsUiState : StateFlow<TvShowDetailsUiState> = _tvShowDetailsUiState

   private val args = TvShowDetailsArgs(savedStateHandle)
   init {
      getTvShowDetailsBy(args.id)
      getTvShowReviewList(args.id)
   }

   private fun getTvShowReviewList(id : Int) {
      viewModelScope.launch {
         getTvShowReviewUseCase.getTvShowReviewList(id).collect{ tvShowReviewState ->
            when(tvShowReviewState){
               is MovieState.Error -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowReviewState = tvShowDetailsUiState.tvShowReviewState.copy(error = true)) }
               }
               MovieState.Loading -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowReviewState = tvShowDetailsUiState.tvShowReviewState.copy(loading = true)) }
               }
               is MovieState.Success -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowReviewState = tvShowDetailsUiState.tvShowReviewState.copy(error = false, loading = false, reviewList = tvShowReviewState.data)) }
               }
            }
         }
      }
   }

   private fun getTvShowDetailsBy(id : Int) {
      viewModelScope.launch {
         getTvShowDetailsUseCase.getTvShowDetailsBy(id).collect{ tvShowDetailsState ->
            when(tvShowDetailsState){
               is MovieState.Error -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowDetailsState = tvShowDetailsUiState.tvShowDetailsState.copy(error = true)) }
               }
               MovieState.Loading -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowDetailsState = tvShowDetailsUiState.tvShowDetailsState.copy(loading = true)) }
               }
               is MovieState.Success -> {
                  _tvShowDetailsUiState.update { tvShowDetailsUiState -> tvShowDetailsUiState.copy(tvShowDetailsState = tvShowDetailsUiState.tvShowDetailsState.copy(error = false, loading = false, tvShowDetails = tvShowDetailsState.data)) }
               }
            }
         }
      }
   }
}