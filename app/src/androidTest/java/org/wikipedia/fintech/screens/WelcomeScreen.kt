package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class WelcomeScreen {
    private val skipButtonMatcher = withId(R.id.fragment_onboarding_skip_button)

    fun clickSkipButton(){
        onView(skipButtonMatcher).perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: WelcomeScreen.() -> Unit) = WelcomeScreen().block()
    }
}