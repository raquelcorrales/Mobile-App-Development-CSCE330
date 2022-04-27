package com.mj.com.example.worddictionary.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

// @Entity
data class Word(
    val id: String
) : Parcelable {
}