package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class BottomNavigationBarScreen {
    private val moreButtonMatcher = withId(R.id.nav_more_container)
    private val accountButtonMatcher = withId(R.id.main_drawer_account_container)
    private val settingsButtonMatcher = withId(R.id.main_drawer_settings_container)

    fun clickMoreButton(){
        onView(moreButtonMatcher).perform(click())
    }

    fun clickAccountButton(){
        onView(accountButtonMatcher).perform(click())
    }

    fun clickSettingsButton(){
        onView(settingsButtonMatcher).perform(click())
    }





    companion object {
        inline operator fun invoke(crossinline block: BottomNavigationBarScreen.() -> Unit) = BottomNavigationBarScreen().block()
    }
}