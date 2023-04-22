package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.core.AllOf
import org.wikipedia.R

class CustomizeTheFeedScreen {

    private val anyUncheckedCheckboxMatcher = AllOf(
        withId(R.id.feed_content_type_checkbox),
        isNotChecked()
    )


    fun checkNoneCheckboxesAreChecked() {
        onView(anyUncheckedCheckboxMatcher)
            .check(doesNotExist())
    }


    companion object {
        inline operator fun invoke(crossinline block: CustomizeTheFeedScreen.() -> Unit) = CustomizeTheFeedScreen().block()
    }
}