package com.example.moviesapp.home_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
   suspend fun getTvShowListBy(category : String) : Flow<MovieState<List<TvShow>>>
}