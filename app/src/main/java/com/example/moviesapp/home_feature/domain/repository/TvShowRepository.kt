package com.example.moviesapp.home_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.home_feature.domain.model.TvShowDetails
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
   suspend fun getTvShowListBy(category : String) : Flow<MovieState<List<TvShow>>>
   suspend fun getTrendingTvShowList() : Flow<MovieState<List<TvShow>>>

   suspend fun getTvShowDetailsBy(id : Int) : Flow<MovieState<TvShowDetails>>

   suspend fun getTvShowReviewList(id : Int) : Flow<MovieState<List<Review>>>
}