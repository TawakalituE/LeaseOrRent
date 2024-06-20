package com.example.euniceadinlewa_comp304lab2_ex1


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetachedHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detached_home)

        val detachedName1 = "Detached Home 1"
        val detachedAddress1 = "789 Maple St, Springfield"
        val detachedPrice1 = "$2500/month"

        val detachedName2 = "Detached Home 2"
        val detachedAddress2 = "321 Pine St, Springfield"
        val detachedPrice2 = "$2700/month"

        // Text views for first detached home
        val textViewDetachedName1 = findViewById<TextView>(R.id.textViewDetachedName1)
        val textViewDetachedAddress1 = findViewById<TextView>(R.id.textViewDetachedAddress1)
        val textViewDetachedPrice1 = findViewById<TextView>(R.id.textViewDetachedPrice1)

        textViewDetachedName1.text = detachedName1
        textViewDetachedAddress1.text = detachedAddress1
        textViewDetachedPrice1.text = detachedPrice1

        // Image view for first detached home
        val imageViewDetached1 = findViewById<ImageView>(R.id.imageViewDetached1)
        imageViewDetached1.setImageResource(R.drawable.new_rental_detached_home)

        // Text views for second detached home
        val textViewDetachedName2 = findViewById<TextView>(R.id.textViewDetachedName2)
        val textViewDetachedAddress2 = findViewById<TextView>(R.id.textViewDetachedAddress2)
        val textViewDetachedPrice2 = findViewById<TextView>(R.id.textViewDetachedPrice2)

        textViewDetachedName2.text = detachedName2
        textViewDetachedAddress2.text = detachedAddress2
        textViewDetachedPrice2.text = detachedPrice2

        // Image view for second detached home
        val imageViewDetached2 = findViewById<ImageView>(R.id.imageViewDetached2)
        imageViewDetached2.setImageResource(R.drawable.detached2)

        //  The checkboxes
        val checkBoxVisit1 = findViewById<CheckBox>(R.id.checkBoxVisit1)
        val checkBoxVisit2 = findViewById<CheckBox>(R.id.checkBoxVisit2)

        // Checkout button click listener
        findViewById<Button>(R.id.checkoutButton).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            var isHomeSelected = false

            if (checkBoxVisit1.isChecked) {
                intent.putExtra("homeName1", detachedName1)
                intent.putExtra("homeAddress1", detachedAddress1)
                intent.putExtra("homePrice1", detachedPrice1)
                isHomeSelected = true
            }

            if (checkBoxVisit2.isChecked) {
                intent.putExtra("homeName2", detachedName2)
                intent.putExtra("homeAddress2", detachedAddress2)
                intent.putExtra("homePrice2", detachedPrice2)
                isHomeSelected = true
            }

            if (isHomeSelected) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select at least one detached home for visit", Toast.LENGTH_SHORT).show()
            }
        }

        // Back button click listener
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}
