package com.example.worddictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {


    private val KEY = "WORD_DEFINITION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)

        definition_text_view.text = intent.getStringExtra(KEY)
        back_image_view.setOnClickListener{ finish() }
    }
}
