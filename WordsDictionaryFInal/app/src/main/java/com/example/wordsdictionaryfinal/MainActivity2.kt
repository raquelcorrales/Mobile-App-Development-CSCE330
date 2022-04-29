package com.example.wordsdictionaryfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.wordsdictionaryfinal.database.Word
import org.json.JSONArray

import com.android.volley.Request
import com.example.wordsdictionaryfinal.network.DictionaryApi
import com.example.wordsdictionaryfinal.network.parseJsonToWord
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        find_button.setOnClickListener {
            //SearchWord()
        }
        return
    }

 /*   private fun SearchWord() {

        var searchInput = word_edit_text.text
        var searchword = searchInput.editText?.text.toString()
        Log.d("searchWord", "Search for word ${searchInput.editText?.text.toString()}")
        var word: Word?
        lifecycleScope.launch {
            var response =
                DictionaryApi.retrofitService.getWord(searchInput.editText?.text.toString())
            Log.d("searchWord", response.body()!!.substring(0, 30))
            val jsonString = response.body()!!
            if (jsonString.startsWith("[{")) {
                Log.d("searchWord", "parseJsonToWord")
                word = parseJsonToWord(searchword, jsonString)
            } else {
                Log.d("searchWord", "parseToStringList")
            }

        }
        if (word != null){
            setContentView(R.layout.activity_main3)
            // SEND THE INFORMATION
        }
    }*/

}