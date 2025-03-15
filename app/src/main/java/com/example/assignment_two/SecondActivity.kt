package com.example.assignment_two

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonMain: Button = findViewById<Button>(R.id.btnBack)
        buttonMain.setOnClickListener {
            val intent = Intent(/* packageContext = */ this, /* cls = */ MainActivity::class.java)
            startActivity(intent)
        }

        val buttonCloser: Button = findViewById<Button>(R.id.btnCloseChallenge)
        val buttonChallenger: Button = findViewById<Button>(R.id.btnMyths)
        buttonChallenger.setOnClickListener {
        // Obtain a reference to the TextView
            val textView: TextView = findViewById(R.id.challengeMultiLine)

        // To make the TextView visible
            textView.visibility = View.VISIBLE
            buttonCloser.visibility = View.VISIBLE
            buttonChallenger.visibility=View.INVISIBLE
        }

        buttonCloser.setOnClickListener {
            // Obtain a reference to the TextView
            val textView: TextView = findViewById(R.id.challengeMultiLine)

            // To make the TextView visible
            textView.visibility = View.INVISIBLE
            buttonCloser.visibility=View.INVISIBLE
            buttonChallenger.visibility=View.VISIBLE
        }

        val buttonClick = findViewById<Button>(R.id.btnViewImageAct)
        buttonClick.setOnClickListener {
            val intent = Intent(/* packageContext = */ this, /* cls = */ CaptureImage::class.java)
            startActivity(intent)
        }

    }
}