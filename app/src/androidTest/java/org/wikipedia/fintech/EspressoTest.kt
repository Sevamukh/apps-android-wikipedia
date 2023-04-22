package org.wikipedia.fintech

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.fintech.screens.*
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
    fun checkAllCheckboxesAreChecked() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickSettingsButton()
        }
        SettingsScreen { clickExploreFeedButton() }
        CustomizeTheFeedScreen { checkNoneCheckboxesAreChecked() }
    }

    @Test
    fun checkAboutAppBlocksAreDisplayed() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickSettingsButton()
        }
        SettingsScreen { clickAboutAppButton() }
        AboutAppScreen {
            checkAboutContributorsBlockIsDisplayed()
            checkAboutTranslatorsBlockIsDisplayed()
            checkLicenseBlockIsDisplayed()
        }
    }



}