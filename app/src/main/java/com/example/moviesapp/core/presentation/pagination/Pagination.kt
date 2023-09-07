package com.example.moviesapp.core.presentation.pagination

interface Pagination<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}