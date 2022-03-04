package com.example.twoactivitiesintentextras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val count = message.toString()

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.display_text).apply {
            text = count


        }
    }
}

