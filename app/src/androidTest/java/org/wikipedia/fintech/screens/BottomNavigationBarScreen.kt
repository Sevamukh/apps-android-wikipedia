package org.wikipedia.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.core.AnyOf
import org.wikipedia.R

class BottomNavigationBarScreen {
    private val moreButtonMatcher = withId(R.id.nav_more_container)
    private val settingsButtonMatcher = withId(R.id.main_drawer_settings_container)

    // Settings
    private val exploreFeedButtonMatcher = withChild(
        withChild(
            AnyOf(
        withText("Explore Feed"),
        withText("Настроить ленту")
            )
        )
    )

    private val feedContentCheckboxesMatcher = withId(R.id.feed_content_type_checkbox)

    fun clickMoreButton(){
        Espresso.onView(moreButtonMatcher)
            .perform(ViewActions.click())
    }

    fun clickSettingsButton(){
        Espresso.onView(settingsButtonMatcher)
            .perform(ViewActions.click())
    }




    fun checkTextOnSnackBar() {
        Espresso.onView(feedContentCheckboxesMatcher)
            .check(ViewAssertions.matches(isChecked()))
    }


    companion object {
        inline operator fun invoke(crossinline block: BottomNavigationBarScreen.() -> Unit) = BottomNavigationBarScreen().block()
    }
}