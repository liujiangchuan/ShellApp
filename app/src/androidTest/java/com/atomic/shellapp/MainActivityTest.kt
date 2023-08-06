package com.atomic.shellapp

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyTopBarTitle() {
        composeTestRule.onNodeWithText("ShellApp").assertIsDisplayed()
    }

    @Test
    fun clickRefreshButton() {
        composeTestRule.onNodeWithContentDescription("Refresh").performClick()
        composeTestRule.onNodeWithTag("CircularProgressIndicator").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun verifySportCardDisplayed() {
        composeTestRule.waitUntilDoesNotExist(hasTestTag("CircularProgressIndicator"), 6000)
        composeTestRule.onNodeWithTag("SportCardName").assertIsDisplayed()
        composeTestRule.onNodeWithTag("SportCardDescription").assertIsDisplayed()
    }
}