package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class CustomizeTheFeedScreen {
    private val anyUncheckedCheckboxMatcher = allOf(
        withId(R.id.feed_content_type_checkbox),
        isNotChecked()
    )

    fun checkAllCheckboxesAreChecked() {
        onView(anyUncheckedCheckboxMatcher).check(doesNotExist())
    }

    companion object {
        inline operator fun invoke(crossinline block: CustomizeTheFeedScreen.() -> Unit) = CustomizeTheFeedScreen().block()
    }
}