package com.example.words.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.words.entity.Word

@Dao
interface WordDao {

    @Insert
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Query("SELECT exists(select * from dictionary_word WHERE id = :wordId)")
    suspend fun wordExists(wordId: String): Boolean

    // suspend is not required on the following functions because Room will use a
    // background thread for queries that return LiveData

    // You don't have to define your queries as shown below. You can make one query function
    // pass an argument, or however else you see fit.
    @Query("SELECT * FROM dictionary_word ORDER BY id DESC")
    fun getAllWords(): LiveData<List<Word>>

    @Query("SELECT * FROM dictionary_word where active = 1 ORDER BY id DESC")
    fun getActiveWords(): LiveData<List<Word>>

    @Query("SELECT * FROM dictionary_word where active = 0 ORDER BY id DESC")
    fun getInactiveWords(): LiveData<List<Word>>
}