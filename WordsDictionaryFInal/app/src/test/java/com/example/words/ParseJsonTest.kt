package com.example.words

import com.example.words.network.parseJsonToStringList
import com.example.words.network.parseJsonToWord
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ParseJsonTest {
    @Test
    fun parse_response_with_one_shortdef_string() {
        // Given
        val jsonString = javaClass.getResource("/baseball_word_response.json")?.readText()

        // When
        val word = parseJsonToWord("baseball", jsonString!!)

        // Then
        assertThat(word.id, `is`("baseball"))
        assertThat(word.shortDef1, startsWith("a game played with a bat and ball between"))
        assertThat(word.shortDef1, endsWith("also : the ball used in this game"))
        assertThat(word.shortDef2, `is`(""))
        assertThat(word.shortDef3, `is`(""))
    }

    @Test
    fun parse_response_with_art() {
        // Given
        val jsonString = javaClass.getResource("/moose_word_response.json")?.readText()

        // When
        val word = parseJsonToWord("moose", jsonString!!)

        // Then
        assertThat(word.id, `is`("moose"))
        assertThat(word.imageName, `is`("moose"))
    }

    @Test
    fun parse_json_to_string_list() {
        // Given
        val jsonString = javaClass.getResource("/suggested_words.json")?.readText()

        // When
        val wordList = parseJsonToStringList(jsonString!!)

        // Then
        assertThat(wordList.size, `is`(4))
    }

    @Test
    fun parse_json_to_string_list_when_empty_json_array() {
        // Given
        val jsonString = "[]"

        // When
        val wordList = parseJsonToStringList(jsonString!!)

        // Then
        assertThat(wordList.size, `is`(0))
    }
}