package com.example.moviesapp.core.presentation.pagination

import com.example.moviesapp.home_feature.domain.MovieState
import kotlinx.coroutines.flow.Flow

class DefaultPagination<Key, Item>(
    private val initialKey : Key ,
    private inline val onLoadUpdated : (Boolean) -> Unit ,
    private inline val onRequest : suspend (nextKey : Key) -> Result<Flow<MovieState<Item>>> ,
    private inline val getNextKey : suspend (Flow<MovieState<Item>>) -> Key ,
    private inline val onError : suspend (Throwable?) -> Unit ,
    private inline val onSuccess : suspend (items : Flow<MovieState<Item>>, newKey : Key) -> Unit
) : Pagination<Key, Item> {
    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false
        val items = result.getOrElse {
            onError(it)
            onLoadUpdated(false)
            return
        }
        currentKey = getNextKey(items)
        onSuccess(items, currentKey)
        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }
}