package com.example.wordsdictionaryfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.wordsdictionaryfinal.database.Word
import org.json.JSONArray

import com.android.volley.Request
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val queue= Volley.newRequestQueue( this)
        R.layout.find_button.setOnClickListener {
            val url = getUrl()

            val stringRequest = StringRequest ( Request.Method.GET, url,
                { response ->
                    try {
                        val word = extractDefinitionFromJson(response)
                        start_second_activity(word)
                    } catch (exception : Exception){
                        exception.printStackTrace()}
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }
            )
            queue.add(stringRequest)
        }
    }



    // Function to search the word that is received in the text-box

    private fun getUrl() : String {
        // Here I assigned the value of the text to Word variable
        val word = word_edit_text.text
        // This is the apiKey that I have in Merriam-Webster
        val apiKey = "092d26d4-a170-4f32-8d74-cfd19a4001c3"
        // with this url the word is searched
        val url =
            "https://www.dictionaryapi.com/api/v3/references/collegiate/json/$word?key=$apiKey"
        return url
    }





    fun parseJsonToWord(wordId: String, jsonStr: String): Word {

        val json = JSONArray(jsonStr)
        val entry = json.getJSONObject(0)
        val shortDef = entry.getJSONArray("shortdef")
        var image = ""

        if (entry.has("art")) {
            image = entry.getJSONObject("art").getString("artid")
        }

        val word = when (shortDef.length()) {
            0 -> Word(wordId, "No definition available")
            1 -> Word(wordId, shortDef.getString(0), imageName = image)
            2 -> Word(wordId, shortDef.getString(0), shortDef.getString(1), imageName = image)
            else -> Word(
                wordId, shortDef.getString(0),
                shortDef.getString(1),
                shortDef.getString(2),
                imageName = image
            )
        }
        return word
    }
