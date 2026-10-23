package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // Navigate to the races screen.
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // Verify the races screen opened.
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // Enter a race location.
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // Add the location.
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // Verify the location appears in the list.
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // Return to the home screen.
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // Verify the home screen is displayed.
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // add two drivers
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Daniel Njoku")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Daniel Njoku")
            .assertExists()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Walter White")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Walter White")
            .assertExists()

        // check that clearing removes both
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Daniel Njoku")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("Walter White")
            .assertDoesNotExist()

        // go back home
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}