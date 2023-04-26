package org.wikipedia.fintech

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.fintech.screens.*
import org.wikipedia.main.MainActivity
import org.wikipedia.fintech.testData.CreateAccountData

@RunWith(AndroidJUnit4::class)
class EspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val data = CreateAccountData()

    @Before
    fun setUp() { WelcomeScreen {clickSkipButton()} }

    @Test
    fun checkAllCustomizeTheFeedCheckboxesAreChecked() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickSettingsButton()
        }
        SettingsScreen { clickExploreFeedButton() }
        CustomizeTheFeedScreen { checkNoneCheckboxesAreChecked() }
    }

    /**
     * Тест-кейс №2
     */
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

    /**
     * Тест-кейс №3
     */
    @Test
    fun checkSettingsPrivacyPolicyButtonLink() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickSettingsButton()
        }
        SettingsScreen { checkPrivacyPolicyButtonFollowLink() }
    }

    /**
     * Тест-кейс №4
     */
    @Test
    fun checkCreateAccountPasswordVisibility() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickAccountButton()
        }
        CreateAccountScreen {
            enterPassword(data.shortPassword)
            clickPasswordVisibilityEyeButton()
            checkPasswordIsReadable(data.shortPassword)
            clickPasswordVisibilityEyeButton()
            checkPasswordIsHidden()
        }
    }

    /**
     * Тест-кейс №5
     */
    @Test
    fun checkCreateAccountPasswordFieldValidation() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickAccountButton()
        }
        CreateAccountScreen {
            enterUserName(data.defaultUsername)
            enterPassword(data.shortPassword)
            enterRepeatPassword(data.shortPassword)
            enterEmail(data.defaultEmail)
            clickSubmitButton()
            checkPasswordHintErrorColor()
            checkShortPasswordErrorMessage()
        }
    }



}