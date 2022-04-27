package com.example.worddictionary

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.mj.com.example.worddictionary.database.Word

import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray









class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val queue= Volley.newRequestQueue( this)
        find_button.setOnClickListener {
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
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

//    // Function to obtain the definition and call the second activity with the intent
//    private fun extractDefinitionFromJson(response : String){
//        val jsonArray = JSONArray(response)
//        val firstIndex = jsonArray.getJSONObject(0)
//        val getShortDefinition = firstIndex.getJSONArray("shortdef")
//        // I am trying to obtain all the definitions
//        val firstShortDefinition = getShortDefinition.get(0)
//        val secondShortDefinition = getShortDefinition.get(1)
//        val thirdShortDefinition = getShortDefinition.get(2)
//        // Declaration of the intent
//        val intent = Intent(this, SecondActivity::class.java)
//        intent.putExtra(KEY, firstShortDefinition.toString())
//        // second activity is initialized
//        startActivity(intent)
//
//    }
//}



    // Function to obtain the definition and call the second activity with the intent
    private fun extractDefinitionFromJson(response : String) : Word{
        val jsonArray = JSONArray(response)
        val firstIndex = jsonArray.getJSONObject(0)
        val getShortDefinition = firstIndex.getJSONArray("shortdef")
        // I am trying to obtain all the definitions
        val firstShortDefinition = getShortDefinition.get(0)
        val secondShortDefinition = getShortDefinition.get(1)
        val thirdShortDefinition = getShortDefinition.get(2)
//        val imageName = jsonObject
        val word = Word("word id goes here")

        return word
    }

    private fun start_second_activity(word: Word) {
        val intent = Intent(this, SecondActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("WORD_EXTRA", word)
        //        bundle.putString("EXTRA_1",firstShortDefinition.toString())
        //        bundle.putString("EXTRA_2",secondShortDefinition.toString())
        //        bundle.putString("EXTRA_3",thirdShortDefinition.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}