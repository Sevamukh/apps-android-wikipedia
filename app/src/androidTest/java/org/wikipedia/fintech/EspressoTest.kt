package org.wikipedia.fintech

import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.fintech.screens.*
import org.wikipedia.main.MainActivity
import org.wikipedia.fintech.testData.CreateAccountData
import org.wikipedia.R.string.privacy_policy_url

@RunWith(AndroidJUnit4::class)
class EspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val accountData = CreateAccountData()

    @Before
    fun setUp() { WelcomeScreen {clickSkipButton()} }

    /**
     * Тест-кейс №1
     */
    @Test
    fun checkAllCustomizeTheFeedCheckboxesAreChecked() {
        BottomNavigationBarScreen {
            clickMoreButton()
            clickSettingsButton()
        }
        SettingsScreen { clickExploreFeedButton() }
        CustomizeTheFeedScreen { checkAllCheckboxesAreChecked() }
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
        val uri = InstrumentationRegistry.getInstrumentation().targetContext
            .getString(privacy_policy_url)
        Intents.init()
            SettingsScreen { clickPrivacyPolicyButton() }
            Intents.intended(hasAction(Intent.ACTION_VIEW))
            Intents.intended(hasData(uri))
        Intents.release()
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
            enterPassword(accountData.shortPassword)
            clickPasswordVisibilityEyeButton()
            checkPasswordIsReadable(accountData.shortPassword)
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
            enterUserName(accountData.defaultUsername)
            enterPassword(accountData.shortPassword)
            enterRepeatPassword(accountData.shortPassword)
            enterEmail(accountData.defaultEmail)
            clickSubmitButton()
            checkPasswordHintErrorColor()
            checkShortPasswordErrorMessage()
        }
    }
}