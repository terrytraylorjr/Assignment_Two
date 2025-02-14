package com.example.assignment_two

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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