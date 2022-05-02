package com.example.words.screens.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.words.database.WordDao
import com.example.words.entity.Word

class DictWordsViewModel(
    dao: WordDao,
    application: Application
) : AndroidViewModel(application) {

    private val _dictWords = dao.getActiveWords()

    val dictWords: LiveData<List<Word>>
        get() = _dictWords

    fun changeFilter(filter: String) {
    }
}