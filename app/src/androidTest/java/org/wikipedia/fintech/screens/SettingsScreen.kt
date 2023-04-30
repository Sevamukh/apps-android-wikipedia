package org.wikipedia.fintech.screens

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.wikipedia.R

class SettingsScreen {
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

    private val privacyPolicyButtonMatcher = withChild(
        withChild(
            withText(R.string.privacy_policy_description)
        )
    )

    fun clickExploreFeedButton(){
        scrollToRecyclerView(exploreFeedButtonMatcher)
        onView(exploreFeedButtonMatcher).perform(click())
    }

    fun clickAboutAppButton(){
        scrollToRecyclerView(aboutAppButtonMatcher)
        onView(aboutAppButtonMatcher).perform(click())
    }

    fun clickPrivacyPolicyButton(){
        scrollToRecyclerView(privacyPolicyButtonMatcher)
        onView(privacyPolicyButtonMatcher).perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: SettingsScreen.() -> Unit) = SettingsScreen().block()
    }
}

private fun scrollToRecyclerView(matcherToItem: Matcher<View>) {
    onView(withId(R.id.recycler_view))
        .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(matcherToItem))
}