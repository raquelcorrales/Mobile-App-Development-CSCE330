package com.example.twoactivitiesintentextras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


const val EXTRA_MESSAGE = "com.example.twoactivitiesintentextras.MESSAGE"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        }

    /*Function for the first button*/
    fun launchFirstActivity(view: android.view.View) {
//        get the views from their IDs
        val mes1: String = getString(R.string.display_one)
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, mes1)
        }
        startActivity(intent)
    }

    /*Function for the second button*/
    fun launchSecondActivity(view: android.view.View) {
        val mes2: String = getString(R.string.display_two)
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, mes2)
        }
        startActivity(intent)
    }

    /*Function for the third button*/
    fun launchThirdActivity(view: android.view.View) {
        val mes3: String = getString(R.string.display_three)
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, mes3)
        }
        startActivity(intent)
    }

}





