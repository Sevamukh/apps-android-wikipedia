package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.wikipedia.R

class BottomNavigationBarScreen {
    private val moreButtonMatcher = withId(R.id.nav_more_container)
    private val settingsButtonMatcher = withId(R.id.main_drawer_settings_container)




    fun clickMoreButton(){
        onView(moreButtonMatcher).perform(click())
    }

    fun clickSettingsButton(){
        onView(settingsButtonMatcher).perform(click())
    }





    companion object {
        inline operator fun invoke(crossinline block: BottomNavigationBarScreen.() -> Unit) = BottomNavigationBarScreen().block()
    }
}