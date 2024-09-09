package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

open class BaseTest {
    fun waitThenClick(id: Int) {
        // Wait until element is visible
        waitUntilElementIsDisplayed(id)
        onView(withId(id)).perform(click())
    }

    fun waitUntilElementIsDisplayed(id: Int) {
        var found = false;
        while(!found) {
            try {
                onView(withId(id)).check(matches(isDisplayed()))
                found = true;
            } catch (e: Exception) {
                Thread.sleep(500)
            }
        }
    }
}