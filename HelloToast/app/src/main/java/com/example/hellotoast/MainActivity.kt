package com.example.hellotoast

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

const val KEY_TIMER_SECONDS = "timer_seconds_key"
const val EXTRA_MESSAGE = "com.example.hellotoast.MESSAGE"
private const val STATE_COUNTER = "counter"
const val KEY_REVENUE = "revenue_key"
class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var mShowCount: TextView
    private val KEY_INDEX = "index"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)

        /*Task 1*/
        val count_Button: Button = findViewById(R.id.button_count)
        count_Button.setOnClickListener { countUp() }

        val toast_Button: Button = findViewById(R.id.button_toast)
        toast_Button.setOnClickListener { showToast() }
    }

    private fun showToast() {
        // delete the lines
        // val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        // toast.show()

        // first convert the mCount to a string value
        val count = mCount.toString()
        // using "intent" value I passed the count and I start the second activity
        val intent = Intent(this, HelloActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, count)
        }
        startActivity(intent)
    }


    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }

    // I used the onSaveInstanceState to preserve the value of the count
    // when the app is rotated
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val number : Int = mCount
        outState.putInt("savedInt", mCount)
    }

    // I used the onRestoreInstanceState to obtain the value of the count
    // after the app is rotated
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val number2: Int = savedInstanceState.getInt("savedInt", 0)
        mCount = number2
        // in this part I show again the mShowCount TextView
        mShowCount.text = mCount.toString()
    }


}
