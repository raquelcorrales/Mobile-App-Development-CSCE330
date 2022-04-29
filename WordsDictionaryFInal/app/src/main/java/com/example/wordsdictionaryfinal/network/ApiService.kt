package com.example.wordsdictionaryfinal.network

import androidx.compose.ui.graphics.Path
import com.android.volley.Response
import com.example.wordsdictionaryfinal.database.Word
import org.json.JSONArray
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET



private const val BASE_URL = "https://www.dictionaryapi.com/api/v3/references/collegiate/json/"
private const val API_KEY = "092d26d4-a170-4f32-8d74-cfd19a4001c3"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DictionaryApiService {
    @GET("{word}?key=${API_KEY}")
    suspend fun getWord(@retrofit2.http.Path("word") type: String): Response<String>
}

object DictionaryApi{
    val retrofitService : DictionaryApiService by lazy {
        retrofit.create(DictionaryApiService::class.java)}
}