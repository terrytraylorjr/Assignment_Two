package com.example.assignment_two

/*  Assignment 5: UI Automator Test
Terry Traylor
 */

//Dependencies
import android.content.Intent
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

//Variables
private const val TIMEOUT = 5000L

//Needed to set the Test Runner
@RunWith(AndroidJUnit4::class)

//Start of the UI Test Class
class UIAutomatorTestClass {

    //Variables
    private val packageName = "com.example.assignment_two" // Change this to your target app

    //The @Test Method
    @Test
    fun launchMainActivityFromHomeScreen() {
        //Retrieving the Instrumentation to interact with the UI and devices
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val device = UiDevice.getInstance(instrumentation)

        // Requirement 1: Start app from home screen
        device.pressHome()

        // Create intent to start the app's main activity
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        // Create the intent to launch the MainActivity
        val intent = Intent(context, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // required when launching from outside an activity
        }

        // Start the activity like launching from app icon
        instrumentation.startActivitySync(intent)

        // Optionally wait for it to appear
        device.waitForIdle()

        // Requirement 2: Locate the button by text and click it
        val submitButton = device.findObject(By.text("Start Intent Explicitly"))

        // Simulate a user-click on the submit button, if found.
        if (submitButton != null) {
            submitButton.click()
        }

        // Requirement 3:  Find object that contains text from a challenge
        val textObject = device.findObject(
            UiSelector().textContains("Fragmentation")
        )

        // Get the text content
        val textContent = textObject.text

        // Check that the text contains the expected substring
        assertTrue("Challenges Found", textContent.contains("Fragmentation"))

        //Added this test point for visibility in logcat                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      for Troubleshooting Reference
        Log.d("TestLog", "Challenges Found")

    }
}