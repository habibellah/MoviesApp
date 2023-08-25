package com.example.moviesapp.search_feature.presentation.screens.generalSearchScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.search_feature.domain.useCase.SearchMediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GeneralSearchViewModel @Inject constructor(
   private val searchMediaUseCase : SearchMediaUseCase
) : ViewModel() {

   private val _generalSearchUiState : MutableStateFlow<GeneralSearchUiState> = MutableStateFlow(
      GeneralSearchUiState()
   )
   val generalSearchUiState : StateFlow<GeneralSearchUiState> = _generalSearchUiState.asStateFlow()

   private var searchJob : Job? = null
   fun searchMediaByQuery(query : String , mediaType : String) {
      searchJob?.cancel()
      searchJob = viewModelScope.launch {
         delay(500)
         _generalSearchUiState.update { generalSearchState -> generalSearchState.copy(error = false, loading = false, mediaSearchList = emptyList()) }
         searchMediaUseCase.searchMediaByQuery(query , mediaType = mediaType).collect{ searchMediaState ->
            when(searchMediaState){
               is MovieState.Error -> {
                  _generalSearchUiState.update { generalSearchState -> generalSearchState.copy(error = true) }
               }
              is MovieState.Loading -> {
                 _generalSearchUiState.update { generalSearchState -> generalSearchState.copy(loading = true) }
              }
               is MovieState.Success -> {
                  _generalSearchUiState.update { generalSearchState -> generalSearchState.copy(error = false, loading = false, mediaSearchList = searchMediaState.data) }
               }
            }
         }
      }
   }
}