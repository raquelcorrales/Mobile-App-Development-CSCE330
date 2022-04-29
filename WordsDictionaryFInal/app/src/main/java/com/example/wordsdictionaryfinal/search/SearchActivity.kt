package com.example.wordsdictionaryfinal.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.wordsdictionaryfinal.R


class SearchActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val button = findViewById<Button>(R.id.find_button)
        button.setOnClickListener {
            searchWord()
        }
        return
    }

    private fun searchWord() {

        var searchWord = findViewById<EditText>(R.id.word_edit_text).text.toString()
        Log.d("searchWord", "Search for word ${searchWord}")
//        var word: Word?
//        lifecycleScope.launch {
//            var response =
//                DictionaryApi.retrofitService.getWord(searchInput.editText?.text.toString())
//            Log.d("searchWord", response.body()!!.substring(0, 30))
//            val jsonString = response.body()!!
//            if (jsonString.startsWith("[{")) {
//                Log.d("searchWord", "parseJsonToWord")
//                word = parseJsonToWord(searchword, jsonString)
//            } else {
//                Log.d("searchWord", "parseToStringList")
//            }
//
//        }
//        if (word != null){
//            setContentView(R.layout.activity_add)
//            // SEND THE INFORMATION
//        }
    }

}