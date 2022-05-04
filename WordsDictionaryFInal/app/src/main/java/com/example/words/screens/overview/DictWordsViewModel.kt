package com.example.words.screens.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.words.database.WordDao
import com.example.words.database.WordDatabase
import com.example.words.entity.Word


enum class WordsFilter {
    SHOW_ALL,
    SHOW_ACTIVE,
    SHOW_INACTIVE
}

class DictWordsViewModel(
    dao: WordDao,
    application: Application
) : AndroidViewModel(application) {

    // I am not sure if this is the right declaration for (dao) that is used in lines 39-41
  private val dao = WordDatabase.getInstance(application).wordDao

    private var _currentFilter = MutableLiveData<WordsFilter>()
    val currentFilter: LiveData<WordsFilter>
        get() = _currentFilter

    var dictWords: LiveData<List<Word>>

    init {
        dictWords = dao.getActiveWords()
        _currentFilter.value = WordsFilter.SHOW_ACTIVE
    }

    fun changeFilter(filter: WordsFilter) {
        dictWords = when (filter) {
            WordsFilter.SHOW_ALL -> dao.getAllWords()
            WordsFilter.SHOW_ACTIVE -> dao.getActiveWords()
            else -> dao.getInactiveWords()
        }
        _currentFilter.value = filter
    }

}