package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var mShowCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
    }

    private fun showToast() {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }
}