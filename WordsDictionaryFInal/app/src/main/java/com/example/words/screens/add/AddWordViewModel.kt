package com.example.words.screens.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.words.entity.Word
import com.example.words.database.WordDao
import com.example.words.database.WordDatabase
import kotlinx.coroutines.launch



enum class AddWordStatus{
    SUCCESS,
    FAILED,
    DUPLICATE
}

class AddWordViewModel(val word: Word, private val wordDao: WordDao) : ViewModel(){
private val TAG = javaClass.simpleName
private var _addWordStatus = MutableLiveData<AddWordStatus>()
val addWordStatus: LiveData<AddWordStatus>
    get() = _addWordStatus

fun addWord(){
    viewModelScope.launch {
        try{
            if(wordDao.wordExists(word.id))
            {
                _addWordStatus.value = AddWordStatus.DUPLICATE
            }
            else{
                wordDao.insertWord(word)
                _addWordStatus.value = AddWordStatus.SUCCESS

            }
        }
        catch (e: Exception){
            Log.e(TAG, "ERROR, inserting word ${e.printStackTrace()}")
            _addWordStatus.value = AddWordStatus.FAILED

        }
    }
}

}

