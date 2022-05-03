package com.example.words.screens.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.words.database.WordDao
import com.example.words.entity.Word

class AddWordViewModelFactory
(private val word: Word, private val wordDao: WordDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddWordViewModel::class.java)) {
            //return AddWordViewModel(word, application) as T
            return AddWordViewModel(word, wordDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}