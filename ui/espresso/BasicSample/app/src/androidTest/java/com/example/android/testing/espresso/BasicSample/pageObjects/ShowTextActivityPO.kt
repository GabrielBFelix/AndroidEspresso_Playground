package com.example.android.testing.espresso.BasicSample.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.android.testing.espresso.BasicSample.BasePO
import com.example.android.testing.espresso.BasicSample.R

class ShowTextActivityPO: BasePO() {
    private var textView = onView(withId(R.id.show_text_view));

    open fun verifyChangedText(text: String) {
        waitUntilElementIsDisplayed(R.id.show_text_view)
        textView.check(matches(withText(text)))
    }

}