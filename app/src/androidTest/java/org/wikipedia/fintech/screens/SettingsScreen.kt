package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.core.AnyOf
import org.wikipedia.espresso.screens.BottomNavigationBarScreen

class SettingsScreen {

    private val exploreFeedButtonMatcher = ViewMatchers.withChild(
        ViewMatchers.withChild(
            AnyOf(
                ViewMatchers.withText("Explore Feed"),
                ViewMatchers.withText("Настроить ленту")
            )
        )
    )

    fun clickExploreFeedButton(){
        Espresso.onView(exploreFeedButtonMatcher)
            .perform(ViewActions.click())
    }



    companion object {
        inline operator fun invoke(crossinline block: SettingsScreen.() -> Unit) = SettingsScreen().block()
    }
}