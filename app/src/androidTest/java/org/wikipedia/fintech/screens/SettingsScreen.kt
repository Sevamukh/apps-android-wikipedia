package org.wikipedia.fintech.screens

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher
import org.wikipedia.R

class SettingsScreen {

    private val mainViewMatcher = withId(R.id.recycler_view)

    private val exploreFeedButtonMatcher = withChild(
        withChild(
            withText(R.string.preference_title_customize_explore_feed)
        )
    )

    private val aboutAppButtonMatcher = withChild(
        withChild(
            withText(R.string.about_description)
        )
    )

    fun clickExploreFeedButton(){
        onView(exploreFeedButtonMatcher).perform(click())
    }

    fun clickAboutAppButton(){
        scrollToItem(aboutAppButtonMatcher)
        onView(aboutAppButtonMatcher).perform(click())
    }

    private fun scrollToItem(matcherToItem : Matcher<View>) {
        onView(mainViewMatcher)
            .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(matcherToItem))
    }


    companion object {
        inline operator fun invoke(crossinline block: SettingsScreen.() -> Unit) = SettingsScreen().block()
    }
}