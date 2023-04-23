package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.not
import org.hamcrest.core.AllOf
import org.wikipedia.R
import org.wikipedia.fintech.matchers.IsPasswordHidden


class CreateAccountScreen {
    private val passwordFieldMatcher = withHint(R.string.account_creation_password_hint)
    private val visibilityEyeIconMatcher = AllOf(
        isDescendantOfA(withId(R.id.create_account_password_input)),
        withContentDescription(com.google.android.material.R.string.password_toggle_content_description),
    )
    private val defaultLogin = "Vsevolod"
    private val shortPassword = "123"
    private val defaultEmail = "test@example.qa"

    fun enterPassword() {
        onView(passwordFieldMatcher).perform(typeText(shortPassword))
    }

    fun clickPasswordVisibilityEyeButton() {
        onView(visibilityEyeIconMatcher).perform(click())
    }

    fun checkPasswordIsHidden() {
        onView(passwordFieldMatcher).check(matches(IsPasswordHidden()))
    }

    fun checkPasswordIsReadable() {
        onView(passwordFieldMatcher).check(matches(AllOf(
            not(IsPasswordHidden()), withText(shortPassword)
        )))
    }

    companion object {
        inline operator fun invoke(crossinline block: CreateAccountScreen.() -> Unit) = CreateAccountScreen().block()
    }
}