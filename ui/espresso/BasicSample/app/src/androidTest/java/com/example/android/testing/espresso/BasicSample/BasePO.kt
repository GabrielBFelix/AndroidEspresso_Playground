package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText

open class BasePO : BaseTest() {
    fun clickBack() {
        Espresso.pressBack()
    }

    fun typeInput(view: ViewInteraction, text: String) {
        view.perform(replaceText(text), closeSoftKeyboard())
    }
}
