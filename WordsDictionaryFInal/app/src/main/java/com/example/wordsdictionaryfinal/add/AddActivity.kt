package com.example.wordsdictionaryfinal.add



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wordsdictionaryfinal.R

class AddActivity : AppCompatActivity() {

    private val KEY = "WORD_DEFINITION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
//        val bundle = intent.extras
//
//        val def1 = bundle!!.getString("EXTRA_1")
//
//        val def2 = bundle!!.getString("EXTRA_2")
//
//        val def3 = bundle!!.getString("EXTRA_3")
//
//        definition1.text = def1
//        definition2.text = def2
//        definition3.text = def3

        //back_image_view.setOnClickListener{ finish() }
    }
}