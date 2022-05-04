package com.example.words.screens.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.words.R
import com.example.words.database.WordDao
import com.example.words.entity.Word
import com.example.words.network.DictionaryApi
import com.example.words.network.parseJsonToStringList
import com.example.words.network.parseJsonToWord
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

// The view model uses the database (dao) and the API to
// access data for this fragment.
class SearchWordViewModel(private val dao: WordDao) : ViewModel() {
    private val TAG = javaClass.simpleName

    // The fragment observes changes to the wordDef, so that when wordDef
    // is populated with a word found using the API it can navigate
    // to the add word fragment
    private val _wordDef = MutableLiveData<Word>()
    val wordDef: LiveData<Word>
        get() = _wordDef

    // The fragment observes changes to the suggestedWords, so that when it
    // is populated with a word found using the API it displays the list
    // of suggestion on the screen.
    private val _suggestedWords = MutableLiveData<List<String>>()
    val suggestedWords: LiveData<List<String>>
        get() = _suggestedWords

    // Search the API for the searchWord
    fun performWordSearch(searchWord: String) {
        Log.d(TAG, "Search for word $searchWord")
        if (searchWord.isBlank()) {
            return
        }

        viewModelScope.launch {
            // call dao.wordExists(searchWord)
            var response = DictionaryApi.retrofitService.getWord(searchWord)
            Log.d(TAG, response.body()!!.substring(0, 30))
            val jsonString = response.body()!!
            if (jsonString.startsWith("[{")) {
                Log.d(TAG, "parseJsonToWord")
                _wordDef.value = parseJsonToWord(searchWord, jsonString)
            } else {
                Log.d(TAG, "TODO parseToStringList")
                _suggestedWords.value = parseJsonToStringList(jsonString)
            }
        }
    }

    fun isWordInDictionary(searchWord: String): Boolean {
        TODO("Use the dao to check if the word already exists in the datbase")
    }

    @SuppressLint("NullSafeMutableLiveData")
    // This is needed so that observers (the fragment) can reset the wordDef
    // to prevent re-triggering of the data change event.
    fun resetWordDef() {
        _wordDef.value = null
    }
}