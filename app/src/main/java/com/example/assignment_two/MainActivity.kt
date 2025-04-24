package com.example.assignment_two

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Variables Required to Execute Requirement 3
    private val REQUEST_ASSIGNMENT5_PERMISSION = 205
    private val CUSTOM_PERMISSION = "com.Assignment_Two.MSE412"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Launch the activity code
        // Start the second (protected and exported) activity
        fun launchSecondActivity() {
            val intent = Intent("com.secondactivity")
            intent.setPackage("com.example.assignment_two") // Make sure it targets your own app
            startActivity(intent)
        }

        //Requirement 3:  Request Permission from the main activity
        // Request the custom dangerous permission at startup
        if (ContextCompat.checkSelfPermission(this, CUSTOM_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(CUSTOM_PERMISSION), REQUEST_ASSIGNMENT5_PERMISSION)
        } else {
            launchSecondActivity()
        }

        val buttonClick = findViewById<Button>(R.id.btnExplicit)
        buttonClick.setOnClickListener {
            val intent = Intent(/* packageContext = */ this, /* cls = */ SecondActivity::class.java)
            startActivity(intent)
        }

        val implicitClick: Button = findViewById(R.id.btnImplicit)
        implicitClick.setOnClickListener{
            val intent = Intent("com.secondactivity")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Handle the case where no app can handle the intent
            }
        }
    }
}