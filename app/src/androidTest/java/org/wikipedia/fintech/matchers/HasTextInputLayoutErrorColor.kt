package org.wikipedia.fintech.matchers

import android.content.res.Resources
import android.view.View
import androidx.annotation.ColorRes
import androidx.test.platform.app.InstrumentationRegistry
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class HasTextInputLayoutErrorColor(@ColorRes resId: Int): TypeSafeMatcher<View>() {
    val color = colorRes(resId)
    override fun describeTo(description: Description) {
        description.appendText("textInputLayout.errorCurrentTextColors is ${getHexColor(color)}")
    }

    override fun matchesSafely(item: View?): Boolean {
        if (item !is TextInputLayout) { return false }
        return item.errorCurrentTextColors == color
    }

    @Suppress("MagicNumber")
    private fun getHexColor(color: Int): String {
        return String.format("#%08X", color)
    }
}

private fun colorRes(@ColorRes resId: Int, theme: Resources.Theme? = null): Int {
    return InstrumentationRegistry.getInstrumentation().targetContext.resources.getColor(resId, theme)
}