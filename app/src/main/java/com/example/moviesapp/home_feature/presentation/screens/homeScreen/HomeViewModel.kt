package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetAiringTodayTvShowUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetNowStreamingMovieUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetOnTheAirTvShowUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetPopularMovieUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetTopRatedMovieUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetTrendingTvShowUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetUpComingMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val getPopularMovieUseCase : GetPopularMovieUseCase ,
   private val getAiringTodayTvShowUseCase : GetAiringTodayTvShowUseCase ,
   private val getOnTheAirTvShowUseCase : GetOnTheAirTvShowUseCase,
   private val getTrendingTvShowUseCase : GetTrendingTvShowUseCase,
   private val getNowStreamingMovieUseCase : GetNowStreamingMovieUseCase,
   private val getUpComingMovieUseCase : GetUpComingMovieUseCase,
   private val getTopRatedMovieUseCase : GetTopRatedMovieUseCase
) : ViewModel() {
   private val _homeUiState : MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
   val homeUiState : StateFlow<HomeUiState> = _homeUiState

   init {
      getPopularMovieList()
      getTopRatedMovieList()
      getUpComingMovieList()
      getNowStreamingMovieList()
      getAiringTodayTvShowList()
      getOnTheAirTvShowList()
      getTrendingTvShowList()
   }

   private fun getTopRatedMovieList() {
      viewModelScope.launch {
         getTopRatedMovieUseCase.getTopRatedMovieList().collect { topRatedMovieState ->
            when (topRatedMovieState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        topRatedMovie = homeUiState.topRatedMovie.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        topRatedMovie = homeUiState.topRatedMovie.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        topRatedMovie = homeUiState.topRatedMovie.copy(
                           loading = false ,
                           error = false ,
                           topRatedMovieList = topRatedMovieState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getUpComingMovieList() {
      viewModelScope.launch {
         getUpComingMovieUseCase.getUpComingMovieList().collect { upComingMovieState ->
            when (upComingMovieState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        upComingMovie = homeUiState.upComingMovie.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        upComingMovie = homeUiState.upComingMovie.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        upComingMovie = homeUiState.upComingMovie.copy(
                           loading = false ,
                           error = false ,
                           upComingMovieList = upComingMovieState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getNowStreamingMovieList() {
      viewModelScope.launch {
         getNowStreamingMovieUseCase.getNowStreamingMovieList().collect { nowStreamingMovieState ->
            when (nowStreamingMovieState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        nowStreamingMovie = homeUiState.nowStreamingMovie.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        nowStreamingMovie = homeUiState.nowStreamingMovie.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        nowStreamingMovie = homeUiState.nowStreamingMovie.copy(
                           loading = false ,
                           error = false ,
                           nowStreamingMovieList = nowStreamingMovieState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getTrendingTvShowList() {
      viewModelScope.launch {
         getTrendingTvShowUseCase.getTrendingTvShowList().collect { trendingTvShowState ->
            when (trendingTvShowState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        trendingTvShow = homeUiState.trendingTvShow.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        trendingTvShow = homeUiState.trendingTvShow.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        trendingTvShow = homeUiState.trendingTvShow.copy(
                           loading = false ,
                           error = false ,
                           trendingTvShowList = trendingTvShowState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getOnTheAirTvShowList() {
      viewModelScope.launch {
         getOnTheAirTvShowUseCase.getOnTheAirTvShowList().collect { onTheAirTvShowState ->
            when (onTheAirTvShowState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        onTheAirTvShow = homeUiState.onTheAirTvShow.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        onTheAirTvShow = homeUiState.onTheAirTvShow.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        onTheAirTvShow = homeUiState.onTheAirTvShow.copy(
                           loading = false ,
                           error = false ,
                           onTheAirTvShowList = onTheAirTvShowState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getAiringTodayTvShowList() {
      viewModelScope.launch {
         getAiringTodayTvShowUseCase.getAiringTodayTvShowList().collect { airingTodayState ->
            when (airingTodayState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        airingTodayTvShow = homeUiState.airingTodayTvShow.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        airingTodayTvShow = homeUiState.airingTodayTvShow.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        airingTodayTvShow = homeUiState.airingTodayTvShow.copy(
                           loading = false ,
                           error = false ,
                           airingTodayTvShowList = airingTodayState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getPopularMovieList() {
      viewModelScope.launch {
         getPopularMovieUseCase.getPopularMovieList().collect { popularMovieState ->
            when (popularMovieState) {
               is MovieState.Error -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        popularMovie = homeUiState.popularMovie.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        popularMovie = homeUiState.popularMovie.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _homeUiState.update { homeUiState ->
                     homeUiState.copy(
                        popularMovie = homeUiState.popularMovie.copy(
                           loading = false ,
                           error = false ,
                           popularMovieList = popularMovieState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }
}