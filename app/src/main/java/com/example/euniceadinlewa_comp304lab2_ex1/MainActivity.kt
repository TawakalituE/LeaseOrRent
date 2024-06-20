package com.example.euniceadinlewa_comp304lab2_ex1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterButton = findViewById<Button>(R.id.enterButton) // Ensure this matches the ID in XML
        enterButton.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeTypesActivity::class.java)
            startActivity(intent)
        }
    }
}