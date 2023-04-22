package org.wikipedia.fintech.screens

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.wikipedia.R
import androidx.test.platform.app.InstrumentationRegistry


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

    private val privacyPolicyButtonMatcher = withChild(
        withChild(
            withText(R.string.privacy_policy_description)
        )
    )
    private val privacyPolicyUri = R.string.privacy_policy_url

    fun clickExploreFeedButton(){
        onView(exploreFeedButtonMatcher).perform(click())
    }

    fun clickAboutAppButton(){
        scrollToItem(aboutAppButtonMatcher)
        onView(aboutAppButtonMatcher).perform(click())
    }

    private fun clickPrivacyPolicyButton(){
        scrollToItem(privacyPolicyButtonMatcher)
        onView(privacyPolicyButtonMatcher).perform(click())
    }

    fun checkPrivacyPolicyButtonFollowLink(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val uri = context.getString(privacyPolicyUri)
        Intents.init()
        clickPrivacyPolicyButton()
        Intents.intended(
            allOf(hasAction(Intent.ACTION_VIEW), hasData(uri))
        )
        Intents.release()
    }

    private fun scrollToItem(matcherToItem : Matcher<View>) {
        onView(mainViewMatcher)
            .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(matcherToItem))
    }

    companion object {
        inline operator fun invoke(crossinline block: SettingsScreen.() -> Unit) = SettingsScreen().block()
    }
}