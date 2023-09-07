package com.example.moviesapp.home_feature.presentation.screens.seeAllScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.presentation.pagination.DefaultPagination
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.useCase.GetAllMovieCategoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
   private val getAllMovieCategoryList : GetAllMovieCategoryList
) : ViewModel() {
   var state : MutableStateFlow<SeeAllUiState> = MutableStateFlow(SeeAllUiState())
   private val pagination = DefaultPagination<Int , List<Movie>>(
      initialKey = state.value.page ,
      onLoadUpdated = {
         state.update { allUiState -> allUiState.copy(loading = it) }
      } ,
      onRequest = { nextPage ->
         getAllMovieCategoryList.getPopularMovieList("popular" , nextPage)
      } ,
      getNextKey = {
         state.value.page + 1
      } ,
      onError = {
         state.update { allUiState -> allUiState.copy(error = true) }
      } ,
      onSuccess = { items , newKey ->
         val allItems : MutableList<Movie> = mutableListOf()
         items.collect {
            when (it) {
               is MovieState.Error -> {
                  state.update { allUiState -> allUiState.copy(error = true) }
               }

               MovieState.Loading -> {
                  state.update { allUiState -> allUiState.copy(requestLoading = true) }
               }

               is MovieState.Success -> {
                  allItems.addAll(state.value.movieList)
                  allItems.addAll(it.data)
                  state.update { allUiState ->
                     allUiState.copy(
                        error = false ,
                        requestLoading = false ,
                        endReached = it.data.isEmpty() ,
                        page = newKey ,
                        movieList = allItems
                     )
                  }
               }
            }
         }
      }
   )

   init {
      loadNextItems()
   }

   fun loadNextItems() {
      viewModelScope.launch {
         pagination.loadNextItems()
      }
   }
}