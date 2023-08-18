package com.example.moviesapp.search_feature.presentation.screens.tvShowSearchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.search_feature.domain.useCase.SearchTvShowListByGenresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowSearchViewModel @Inject constructor(
   private val searchTvShowListByGenresUseCase : SearchTvShowListByGenresUseCase
) : ViewModel() {

   private val _movieSearchUiState : MutableStateFlow<TvShowSearchUiState> = MutableStateFlow(
      TvShowSearchUiState()
   )
   val movieSearchUiState : StateFlow<TvShowSearchUiState> = _movieSearchUiState.asStateFlow()

   init {
      getTvShowListBy(null)
   }

   fun getTvShowListBy(genres : Int?){
      _movieSearchUiState.update { tvShowSearchUiState -> tvShowSearchUiState.copy(tvShowList = emptyList()) }
      viewModelScope.launch {
         searchTvShowListByGenresUseCase.searchTvShowListByGenresUseCase(genres).collect{ tvShowSearchState ->
            when(tvShowSearchState){
               is MovieState.Error -> {
                  _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(error = true) }
               }
               MovieState.Loading -> {
                  _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(loading = true) }
               }
               is MovieState.Success -> {
                  _movieSearchUiState.update { movieSearchUiState -> movieSearchUiState.copy(tvShowList = tvShowSearchState.data, error = false,loading = false) }
               }
            }
         }
      }
   }
}