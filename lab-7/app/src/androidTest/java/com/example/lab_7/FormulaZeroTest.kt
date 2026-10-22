package com.example.lab_7

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // Navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // Verify drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // Add a driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver is displayed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // Clear the list
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify driver is removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // Return to home screen
        composeTestRule
            .onNodeWithTag("backButtonDrivers")
            .performClick()

        // Verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
