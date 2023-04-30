package org.wikipedia.fintech.matchers

import android.content.res.Resources
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Description

class HasTextViewHintColor(@ColorRes private val resId: Int) : BoundedMatcher<View, TextView>(TextView::class.java) {
    private val color = colorRes(resId)

    override fun describeTo(description: Description) {
        description.appendText("textView.currentHintTextColor is ${getHexColor(color)}")
    }

    override fun matchesSafely(textView: TextView): Boolean {
        //Log.d("HintColorMatcher", "Actual hint color: ${getHexColor(textView.currentHintTextColor)}")
        return textView.currentHintTextColor != color
    }

    @Suppress("MagicNumber")
    private fun getHexColor(color: Int): String {
        return String.format("#%08X", color)
    }
}

private fun colorRes(@ColorRes resId: Int, theme: Resources.Theme? = null): Int {
    return InstrumentationRegistry.getInstrumentation().targetContext.resources.getColor(resId, theme)
}