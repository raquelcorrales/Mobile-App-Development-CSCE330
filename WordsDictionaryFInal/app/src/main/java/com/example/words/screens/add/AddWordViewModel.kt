package com.example.words.screens.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.words.database.WordDao
import com.example.words.database.WordDatabase
import com.example.words.entity.Word


class AddWordViewModel(
    word: Word, application: Application
) : AndroidViewModel(application) {
    val word = word



    fun addwordtodatabase(word: Word) {
        //WordDao.insertWord(word)

        // create an instance of the database and then insert the information

    }


}