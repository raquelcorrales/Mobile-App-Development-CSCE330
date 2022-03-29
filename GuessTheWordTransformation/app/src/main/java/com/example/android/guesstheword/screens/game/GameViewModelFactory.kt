package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.guesstheword.screens.score.ScoreViewModel

class GameViewModelFactory  (private val timerSecond: Int) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
                return GameViewModel(timerSecond) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
