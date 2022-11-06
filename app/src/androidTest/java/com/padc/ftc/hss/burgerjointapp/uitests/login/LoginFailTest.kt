package com.padc.ftc.hss.burgerjointapp.uitests.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padc.ftc.hss.burgerjointapp.R
import com.padc.ftc.hss.burgerjointapp.activities.LoginActivity
import com.padc.ftc.hss.burgerjointapp.utils.EM_LOGIN_FAIL_ERROR_MESSAGE
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
open class LoginFailTest {

    private val activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
    }

    @Test
    fun enterInformation_navigateToMainScreen() {
        onView(withId(R.id.etUserName)).perform(
            typeText(""),
            closeSoftKeyboard()
        )
        onView(withId(R.id.etPassword)).perform(
            typeText(""),
            closeSoftKeyboard()
        )
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(EM_LOGIN_FAIL_ERROR_MESSAGE)))
    }
}

