package com.example.android.testing.espresso.BasicSample.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.android.testing.espresso.BasicSample.BaseTest
import com.example.android.testing.espresso.BasicSample.MainActivity
import com.example.android.testing.espresso.BasicSample.pageObjects.MainActivityPO
import com.example.android.testing.espresso.BasicSample.pageObjects.ShowTextActivityPO
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorKtTest: BaseTest() {

    // Page Objects
    private var homepage = MainActivityPO()

    // Test specific variables
    private val STRING_TO_BE_TYPED = "Espresso"
    private val DEFAULT_STRING = "Hello Espresso!"

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun changeText_sameActivity() {
        homepage.inputText_VerifyTextValue(STRING_TO_BE_TYPED)
    }

    @Test
    fun changeText_newActivity() {
        // Type text, go to second activity and verify new text value
        homepage.inputText_ChangeActivity_VerifyTextValue(STRING_TO_BE_TYPED)

        // Go back and verify that the text on the homepage has not changed
        homepage.clickBack()
        homepage.verifyChangedText(DEFAULT_STRING)
    }

    @Test
    fun textInput_boundaryTesting() {
        // Click "Change Text" button with nothing in the input
        homepage.inputText_VerifyTextValue("")

        // Click "Change Text" button with a string in the input
        homepage.inputText_VerifyTextValue(STRING_TO_BE_TYPED)

        // Click "Change Text" button with integers and special characters in the input
        homepage.inputText_VerifyTextValue("1234567890!@#$%&*()<>~[]/?,;.:-_=+")

        // Click "Change Text" button with long text in the input
        homepage.inputText_VerifyTextValue("test \n test 2 \n \n test 3 \n \n \n test 4 \n \n \n \n test 5 \n \n \n \n \n test 6 fin")

    }
}