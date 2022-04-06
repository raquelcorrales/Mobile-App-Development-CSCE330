package com.example.affirmations;

import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
public class AffirmationsListTests {


    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun scroll_to_item() {
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions
                .scrollTo<RecyclerView.ViewHolder>(
                    withText(R.string.affirmation10)
                )
        )

        onView(withText(R.string.affirmation10))
            .check(matches(isDisplayed())
            )

    }
}
