package com.github.kadehar.arterialpressureapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.github.kadehar.arterialpressureapp", appContext.packageName)
    }

    @Test
    fun changeIconButtonOnApDetailCreateButtonClick() {
        onView(withId(R.id.apDetailsCreateButton)).perform(click())
        onView(withId(R.id.apDetailsSaveButton)).check(matches(isDisplayed()))
    }

    @Test
    fun setTextIntoAPDetailsMorningText() {
        val apRecordToBeTyped = "12080"
        val apRecordToBeSeen = "120/80"

        onView(withId(R.id.apDetailsCreateButton)).perform(click())
        onView(withId(R.id.apDetailsMorningText)).perform(typeText(apRecordToBeTyped))

        onView(withId(R.id.apDetailsMorningText))
            .check(matches(withText(apRecordToBeSeen)))
    }

    @Test
    fun isFiltersVisibleOnAPListFragment() {
        onView(withId(R.id.arterialPressureFilters)).check(matches(isDisplayed()))
    }
}