package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R

class AboutAppScreen {
    private val aboutContributorsBlockMatcher = withText(R.string.about_contributors_heading)
    private val aboutTranslatorsBlockMatcher = withText(R.string.about_translators_heading)
    private val licenseBlockMatcher = withText(R.string.about_app_license_heading)

    fun checkAboutContributorsBlockIsDisplayed(){
        onView(aboutContributorsBlockMatcher)
            .perform(scrollTo())
            .check(matches(isDisplayed()))
    }

    fun checkAboutTranslatorsBlockIsDisplayed(){
        onView(aboutTranslatorsBlockMatcher)
            .perform(scrollTo())
            .check(matches(isDisplayed()))
    }

    fun checkLicenseBlockIsDisplayed(){
        onView(licenseBlockMatcher)
            .perform(scrollTo())
            .check(matches(isDisplayed()))
    }

    companion object {
        inline operator fun invoke(crossinline block: AboutAppScreen.() -> Unit) = AboutAppScreen().block()
    }
}