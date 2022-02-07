package com.example.myapplication64

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val EXTRA_TEXT = "me.mahakagg.threebuttonstwoactivities.extra.TEXT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent = Intent(this, MainActivity2::class.java)


        btnStartAnotherActivity.setOnClickListener {
            intent.putExtra(EXTRA_TEXT, getString(R.string.display_one));
            // start your next activity
            startActivity(intent)
        }

        btnStartAnotherActivity.setOnClickListener {
            intent.putExtra(EXTRA_TEXT, getString(R.string.display_two));
            // start your next activity
            startActivity(intent)
        }

    }
}