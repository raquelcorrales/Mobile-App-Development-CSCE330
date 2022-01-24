@file:JvmName("StringUtils")

package com.google.example.javafriendlykotlin

fun String.toTitleCase(): String {
    if (isNullOrBlank()) {
        return this
    }

    return split(" ").map { word ->
        word.foldIndexed("") { index, working, char ->
            val nextChar = if (index == 0) char.toUpperCase() else char.toLowerCase()
            "$working$nextChar"
        }
    }.reduceIndexed { index, working, word ->
        if (index > 0) "$working $word" else word
    }
}

fun String.nameToLogin(): String {
    if (isNullOrBlank()) {
        return this
    }
    var working = ""
    toCharArray().forEach { char ->
        if (char.isLetterOrDigit()) {
            working += char.toLowerCase()
        } else if (char.isWhitespace() and !working.endsWith(".")) {
            working += "."
        }
    }
    return working
}