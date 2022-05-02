package com.example.words

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.words.network.DictionaryApi
import com.example.words.network.parseJsonToWord
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
// The tests in this class are just for experimenting with the Dictionary API
class DictionaryApiServiceTest {

    @Test
    fun getWord() = runBlocking {
        // Given

        // When
        val response = DictionaryApi.retrofitService.getWord("baseball")

        // Then
        val jsonString = response.body()
        if (jsonString?.startsWith("[{\"meta\":") == true) {
            val word = parseJsonToWord("baseball", jsonString)
            assertThat(word, `is`(notNullValue()))
        } else
            fail("Unexpected response: $jsonString")
    }

    @Test
    fun getMisspelledWord() = runBlocking {
        // Given

        // When
        val response = DictionaryApi.retrofitService.getWord("baseboll")

        // Then
        assertThat(
            response.body(),
            startsWith("[\"baseball\",\"baseballs\"")
        )
    }
}