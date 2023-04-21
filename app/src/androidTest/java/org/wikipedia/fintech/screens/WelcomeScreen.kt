package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.wikipedia.R

class WelcomeScreen {
    private val skipButtonMatcher = ViewMatchers.withId(R.id.fragment_onboarding_skip_button)

    fun clickSkipButton(){
        Espresso.onView(skipButtonMatcher)
            .perform(ViewActions.click())
    }




    companion object {
        inline operator fun invoke(crossinline block: WelcomeScreen.() -> Unit) = WelcomeScreen().block()
    }
}