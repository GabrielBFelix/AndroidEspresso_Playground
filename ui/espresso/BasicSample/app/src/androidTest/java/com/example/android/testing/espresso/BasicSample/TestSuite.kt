package com.example.android.testing.espresso.BasicSample

import com.example.android.testing.espresso.BasicSample.tests.ChangeTextBehaviorKtTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

// Running all tests in a single class
@RunWith(Suite::class)
@Suite.SuiteClasses(
    ChangeTextBehaviorKtTest::class
)
class TestSuite