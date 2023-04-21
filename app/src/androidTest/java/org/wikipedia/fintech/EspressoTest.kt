package org.wikipedia.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.espresso.screens.BottomNavigationBarScreen
import org.wikipedia.fintech.screens.SettingsScreen
import org.wikipedia.fintech.screens.WelcomeScreen
import org.wikipedia.main.MainActivity

@RunWith(AndroidJUnit4::class)
class EspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        WelcomeScreen {clickSkipButton()}
    }

    @Test
    fun fragmentNavigationTest() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickSettingsButton()
        }
        SettingsScreen {clickExploreFeedButton()}


    }



}