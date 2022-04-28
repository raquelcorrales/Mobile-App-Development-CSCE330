package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Menu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_example, menu)
        return true
    }
}