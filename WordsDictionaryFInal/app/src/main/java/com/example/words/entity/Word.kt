package com.example.words.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "dictionary_word")
@Parcelize
data class Word(
    @PrimaryKey
    val id: String,
    val shortDef1: String,
    val shortDef2: String = "",
    val shortDef3: String = "",
    val imageName: String? = null,
    var active: Boolean = true
    ) : Parcelable