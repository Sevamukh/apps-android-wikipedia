package org.wikipedia.fintech.matchers

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class HasTextColor(@ColorInt private val color: Int) : BoundedMatcher<View, TextView>(TextView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("textView.currentTextColor is ${getHexColor(color)}")
    }

    override fun matchesSafely(textView: TextView): Boolean {
        return textView.currentTextColor == color
    }

    @Suppress("MagicNumber")
    private fun getHexColor(color: Int): String {
        return String.format("#%06X", 0xFFFFFF and color)
    }
}