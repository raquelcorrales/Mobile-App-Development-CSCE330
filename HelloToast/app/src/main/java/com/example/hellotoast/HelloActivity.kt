package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        // Get the Intent that started this activity and extract the string
        val count = intent.getStringExtra(EXTRA_MESSAGE)


        // Put the count into the textView2
        val resultText: TextView = findViewById(R.id.textView2)
        resultText.text = count
        }
    }
