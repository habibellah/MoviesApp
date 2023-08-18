package com.example.moviesapp.search_feature.presentation.screens.exploreScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.search_feature.domain.useCase.GetTrendingTvShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.exp

@HiltViewModel
class ExploreViewModel @Inject constructor(
   private val getTrendingTvShowUseCase : GetTrendingTvShowUseCase
): ViewModel() {

   private val _exploreUiState : MutableStateFlow<ExploreUiState> = MutableStateFlow(ExploreUiState())
   val exploreUiState : StateFlow<ExploreUiState> = _exploreUiState.asStateFlow()

   init {
      getTrendingTvShowList()
   }

   private fun getTrendingTvShowList() {
      viewModelScope.launch {
         getTrendingTvShowUseCase.getTrendingTvShowList().collect{ trendingTvShowState ->
            when(trendingTvShowState){
               is MovieState.Error -> {
                  _exploreUiState.update { exploreUiState -> exploreUiState.copy(exploreTvShowState = exploreUiState.exploreTvShowState.copy(error = true))}
               }
               MovieState.Loading -> {
                  _exploreUiState.update { exploreUiState -> exploreUiState.copy(exploreTvShowState = exploreUiState.exploreTvShowState.copy(loading = true))}
               }
               is MovieState.Success -> {
                  _exploreUiState.update { exploreUiState -> exploreUiState.copy(exploreTvShowState = exploreUiState.exploreTvShowState.copy(error = false, loading = false, exploreTvShowList = trendingTvShowState.data))}
               }
            }
         }
      }
   }
}