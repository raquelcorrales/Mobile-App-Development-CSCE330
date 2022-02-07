package com.example.myapplication64

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent







class MainActivity2 : AppCompatActivity() {
    private val displayText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val display = intent.getStringExtra(MainActivity.EXTRA_TEXT)
    }
}