package com.example.affirmations

import android.content.Context
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.Affirmation
import org.junit.Assert.assertEquals
import org.junit.Test
import mockito.Mockito.mock

public class AffirmationsAdapterTests {


    private val context = mock(Context::class.java)

    @Test
    fun adapter_size(){
        val data = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2)
    )

    val adapter = ItemAdapter(context, data)
    assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)

    }
}
