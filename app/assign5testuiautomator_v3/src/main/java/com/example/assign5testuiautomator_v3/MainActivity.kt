package com.example.assign5testuiautomator_v3

//Imports for the UI Test
import android.annotation.SuppressLint
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.runner.RunWith

private const val BASIC_SAMPLE_PACKAGE = "com.example.assignment_two"
private const val LAUNCH_TIMEOUT = 10000L
private const val STRING_TO_BE_TYPED = "UiAutomator"

//@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
//The test class: Requirement 1

class Assign5UIAutomator {
    @SuppressLint("RestrictedApi")
    //@get:Rule
    //val permissionRule: UiAutomationPermissionGranter = UiAutomationPermissionGranter("android.permission.READ_EXTERNAL_STORAGE")

    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
       // device.pressHome()

        /*
        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )
        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE)?.apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )

        val okButton: UiObject2 = device.findObject(
            By.text("btnExplicit").clazz("android.widget.Button")
        )

// Simulate a user-click on the OK button, if found.
        //if (okButton != null) {
         //   okButton.click()
       // } */
    }

}