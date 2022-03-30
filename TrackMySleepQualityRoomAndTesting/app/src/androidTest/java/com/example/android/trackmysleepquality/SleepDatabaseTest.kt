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

package com.example.android.trackmysleepquality

import android.app.usage.UsageEvents
import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.trackmysleepquality.database.SleepDatabase
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeoutException
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class SleepDatabaseTest {
    // This rule is required when testing LiveData objects
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var sleepDao: SleepDatabaseDao
    private lateinit var db: SleepDatabase


    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, SleepDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
        sleepDao = db.sleepDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    //--------------- TESTS ------------------------ //

    // ------------ Test for insertAndGetNight ------------ //
    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() = runBlocking {
        // Given
        val night = SleepNight(sleepQuality = 9)

        // When
        sleepDao.insert(night)

        // Then
        val tonight = sleepDao.getTonight()
        assertThat(tonight?.sleepQuality, `is`(9))
    }


    // ------------ Test for clear ------------ //
    @Test
    @Throws(Exception::class)
    fun clear() = runBlocking {
        sleepDao.insert(SleepNight())
        sleepDao.insert(SleepNight())
        sleepDao.insert(SleepNight())

        val allNights = sleepDao.getAllNights()
        allNights.getOrAwaitValue()
        assertThat(allNights.value?.isNotEmpty(), `is`(true))


        // When data is cleared from the table
        val night = sleepDao.clear()

        //Then the data should be gone
        val clearedNights = sleepDao.getAllNights()
        clearedNights.getOrAwaitValue()
        assertThat(clearedNights.value?.isEmpty(), `is`(true))
    }

    // ------------ Test for getTonight() ------------ //
    @Test
    @Throws(Exception::class)
    fun getTonight() = runBlocking {
        sleepDao.insert(SleepNight(sleepQuality = 9))
        sleepDao.insert(SleepNight(sleepQuality = 5))
        sleepDao.insert(SleepNight(sleepQuality = 3))

        // Then
        val tonight = sleepDao.getTonight()
        assertThat(tonight?.sleepQuality, `is`(3))
    }



    // -------- Test for updateNight --------- //
    @Test
    @Throws(Exception::class)
    fun updateNight() = runBlocking {
        // Given

        sleepDao.insert(SleepNight())
        val tonight = sleepDao.getTonight()

        // Then
        tonight?.sleepQuality = 9
        sleepDao.update(tonight!!)

        val updatedNight = sleepDao.getTonight()
        // Question, why if I update the value, I get an error
        assertThat(updatedNight?.sleepQuality, `is`(9))
    }

    // -------- Test for getAllNights --------- //

    @Test
    fun getAllNights()= runBlocking {
        sleepDao.insert(SleepNight())
        sleepDao.insert(SleepNight())
        sleepDao.insert(SleepNight())

        val allNights = sleepDao.getAllNights()
        allNights.getOrAwaitValue()
        assertThat(allNights.value?.isNotEmpty(), `is`(true))
        assertThat(allNights.value?.size, `is`(3))

       //assertThat(allNights, not(nullValue()))


    }




    // ---------- Test for getByNightID -----------
    @Test
    @Throws(Exception::class)
    fun getByNightID() = runBlocking {
        sleepDao.insert(SleepNight())


        // Then
        val tonight = sleepDao.get(key = 1)
        //problem
        assertThat(tonight?.nightId, `is`(1L))
    }
}


