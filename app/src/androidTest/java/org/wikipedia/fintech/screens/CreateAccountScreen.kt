package org.wikipedia.fintech.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.not
import org.wikipedia.R
import org.wikipedia.fintech.matchers.HasTextInputLayoutErrorColor
import org.wikipedia.fintech.matchers.IsPasswordHidden

class CreateAccountScreen {
    private val usernameFieldMatcher = withHint(R.string.create_account_username_hint)
    private val passwordLayoutMatcher = withId(R.id.create_account_password_input)
    private val passwordFieldMatcher = withHint(R.string.account_creation_password_hint)
    private val shortPasswordErrorMessageMatcher = withText(R.string.create_account_password_error)
    private val passwordRepeatFieldMatcher = withHint(R.string.create_account_password_repeat_hint)
    private val emailFieldMatcher = withHint(R.string.create_account_email_hint)
    private val submitButtonMatcher = withId(R.id.create_account_submit_button)
    private val visibilityEyeIconMatcher = allOf(
        isDescendantOfA(withId(R.id.create_account_password_input)),
        withContentDescription(com.google.android.material.R.string.password_toggle_content_description),
    )

    fun enterUserName(userName: String) {
        onView(usernameFieldMatcher).perform(scrollTo(), typeText(userName))
    }

    fun enterPassword(password: String) {
        onView(passwordFieldMatcher).perform(scrollTo(), typeText(password))
    }

    fun clickPasswordVisibilityEyeButton() {
        onView(visibilityEyeIconMatcher).perform(scrollTo(), click())
    }

    fun enterRepeatPassword(password: String) {
        onView(passwordRepeatFieldMatcher).perform(scrollTo(), typeText(password))
    }

    fun enterEmail(email: String) {
        onView(emailFieldMatcher).perform(scrollTo(), typeText(email))
    }

    fun clickSubmitButton() {
        onView(submitButtonMatcher).perform(scrollTo(), click())
    }

    fun checkPasswordIsHidden() {
        onView(passwordFieldMatcher).check(matches(IsPasswordHidden()))
    }

    fun checkPasswordIsReadable(password: String) {
        onView(passwordFieldMatcher).check(matches(allOf(
            not(IsPasswordHidden()), withText(password)
        )))
    }

    fun checkPasswordHintErrorColor() {
        //onView(passwordFieldMatcher).check(matches(HasTextViewHintColor(R.color.red500))) //"#A2A9B1".toColorInt()
        onView(passwordLayoutMatcher).check(matches(HasTextInputLayoutErrorColor(R.color.red500)))
    }

    fun checkShortPasswordErrorMessage() {
        onView(shortPasswordErrorMessageMatcher).check(matches(allOf(
            anyOf(
                hasTextColor(R.color.red500),
                hasTextColor(R.color.red700),
            ),
            isDisplayed()
        )))
        /*onView(shortPasswordErrorMessageMatcher).check(matches(
            HasTextColor(ResourceUtil.getThemedColor(
                InstrumentationRegistry.getInstrumentation().context,
                R.attr.destructive_color)
            )
        ))*/
    }

    companion object {
        inline operator fun invoke(crossinline block: CreateAccountScreen.() -> Unit) = CreateAccountScreen().block()
    }
}