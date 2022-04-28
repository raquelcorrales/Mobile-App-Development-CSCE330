/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.wordsdictionary.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dictionary_word")
data class Word(
    @PrimaryKey(autoGenerate = true)
    var Id: String,

    @ColumnInfo(name = "shortdef1")
    val shortdef1: String,

    @ColumnInfo(name = "shortdef2")
    val shortdef2: String,

    @ColumnInfo(name = "shortdef3")
    val shortdef3: String,

    @ColumnInfo(name = "active")
    var active: Boolean = true


)