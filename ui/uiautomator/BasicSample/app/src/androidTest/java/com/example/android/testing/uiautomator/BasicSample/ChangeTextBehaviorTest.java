/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.uiautomator.BasicSample;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.os.RemoteException;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ChangeTextBehaviorTest extends BaseTest{

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    @Test
    public void testChangeText_sameActivity() throws RemoteException, InterruptedException {
        // Type text and then press the button.
        mDevice.findObject(By.res(PACKAGE, "editTextUserInput")).setText(STRING_TO_BE_TYPED);
        mDevice.findObject(By.res(PACKAGE, "changeTextBt")).click();

        // Clear the text
        mDevice.findObject(By.res(PACKAGE, "editTextUserInput")).clear();
        Thread.sleep(2000);

        // Verify the test is displayed in the Ui
        UiObject2 changedText = mDevice
                .wait(Until.findObject(By.res(PACKAGE, "textToBeChanged")), 500);
        assertThat(changedText.getText(), is(equalTo(STRING_TO_BE_TYPED)));
    }

    @Test
    public void testChangeText_newActivity() {
        // Type text and then press the button.
        mDevice.findObject(By.res(PACKAGE, "editTextUserInput")).setText(STRING_TO_BE_TYPED);
        mDevice.findObject(By.res(PACKAGE, "activityChangeTextBtn")).click();

        // Verify the test is displayed in the Ui
        UiObject2 changedText = mDevice
                .wait(Until.findObject(By.res(PACKAGE, "show_text_view")), 500);
        assertThat(changedText.getText(), is(equalTo(STRING_TO_BE_TYPED)));
    }
}
