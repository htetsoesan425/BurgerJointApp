package com.padc.ftc.hss.burgerjointapp.uitests.burgerlist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padc.ftc.hss.burgerjointapp.R
import com.padc.ftc.hss.burgerjointapp.activities.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToCartListTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnCart_navigateToCartList() {

        // Click func
        onView(withId(R.id.ivCart))
            .perform(ViewActions.click())

        //
        onView(withId(R.id.btnCheckOut))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}