package com.example.twoactivitiesintentextras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.Settings.Global.getString
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.twoactivitiesintentextras.extra.MESSAGE"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        R.id.button1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            // start your next activity
            startActivity(intent)
        }

    }

}



