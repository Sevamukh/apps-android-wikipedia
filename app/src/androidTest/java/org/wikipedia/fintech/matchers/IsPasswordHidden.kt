package org.wikipedia.fintech.matchers

import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class IsPasswordHidden: TypeSafeMatcher<View>() {
   override fun describeTo(description: Description) {
       description.appendText("Password is hidden")
   }
   override fun matchesSafely(view: View): Boolean {
       if (view !is EditText) { return false }
       val currentTransformationMethod = view.transformationMethod
       return currentTransformationMethod is PasswordTransformationMethod
   }
}