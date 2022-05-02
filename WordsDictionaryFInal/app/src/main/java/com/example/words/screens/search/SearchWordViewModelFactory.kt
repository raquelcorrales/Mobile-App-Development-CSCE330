package com.example.words.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.words.database.WordDao

class SearchWordViewModelFactory(private val dao: WordDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchWordViewModel::class.java)) {
            return SearchWordViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}