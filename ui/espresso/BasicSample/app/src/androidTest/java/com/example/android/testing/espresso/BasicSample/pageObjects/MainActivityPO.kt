package com.example.android.testing.espresso.BasicSample.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.android.testing.espresso.BasicSample.BasePO
import com.example.android.testing.espresso.BasicSample.R

class MainActivityPO: BasePO() {
    private var changedText = onView(withId(R.id.textToBeChanged));
    private var userInput = onView(withId(R.id.editTextUserInput));
    private var changeTextBtn = onView(withId(R.id.changeTextBt));
    private var activityChangeTextBtn = onView(withId(R.id.activityChangeTextBtn));

    fun inputText_VerifyTextValue(text: String) {
        typeInput(userInput,text) // Type Text
        changeTextBtn.perform(click())  // Click "Change Text" button
        changedText.check(matches(withText(text))) // Check that text was changed.
    }

    fun inputText_ChangeActivity_VerifyTextValue(text: String) {
        typeInput(userInput,text) // Type Text
        activityChangeTextBtn.perform(click())  // Click "Open Activity and Change Text" button
        ShowTextActivityPO().verifyChangedText(text) // Check that text was changed.
    }

    fun typeOnUserInput(text: String) { typeInput(userInput,text) }

    fun clickChangeTextBtn() { changeTextBtn.perform(click()) }

    fun verifyChangedText(text: String) { changedText.check(matches(withText(text))) }
}