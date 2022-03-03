package com.example.hellotoast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

const val KEY_TIMER_SECONDS = "timer_seconds_key"
const val EXTRA_MESSAGE = "com.example.hellotoast.MESSAGE"

class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var mShowCount: TextView

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
       // val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
       // toast.show()


        val intent = Intent(this, HelloActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, mCount)
        }
        startActivity(intent)
    }



    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)


    }
}