package com.example.euniceadinlewa_comp304lab2_ex1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CondominiumApartmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condominium_apartment)

        val condoName1 = "Luxury Condominium 1"
        val condoAddress1 = "123 Oceanview Blvd, Miami"
        val condoPrice1 = "$2000/month"

        val condoName2 = "Luxury Condominium 2"
        val condoAddress2 = "456 Seaside Ave, Miami"
        val condoPrice2 = "$2200/month"

        // Text views for first condominium apartment
        val textViewCondoName1 = findViewById<TextView>(R.id.textViewCondoName1)
        val textViewCondoAddress1 = findViewById<TextView>(R.id.textViewCondoAddress1)
        val textViewCondoPrice1 = findViewById<TextView>(R.id.textViewCondoPrice1)

        textViewCondoName1.text = condoName1
        textViewCondoAddress1.text = condoAddress1
        textViewCondoPrice1.text = condoPrice1

        // Image view for first condominium apartment
        val imageViewCondo1 = findViewById<ImageView>(R.id.imageViewCondo1)
        imageViewCondo1.setImageResource(R.drawable.condominium_apartment_image)

        // Text views for second condominium apartment
        val textViewCondoName2 = findViewById<TextView>(R.id.textViewCondoName2)
        val textViewCondoAddress2 = findViewById<TextView>(R.id.textViewCondoAddress2)
        val textViewCondoPrice2 = findViewById<TextView>(R.id.textViewCondoPrice2)

        textViewCondoName2.text = condoName2
        textViewCondoAddress2.text = condoAddress2
        textViewCondoPrice2.text = condoPrice2

        // Image view for second condominium apartment
        val imageViewCondo2 = findViewById<ImageView>(R.id.imageViewCondo2)
        imageViewCondo2.setImageResource(R.drawable.condo2)

        // The checkboxes
        val checkBoxVisit1 = findViewById<CheckBox>(R.id.checkBoxVisit1)
        val checkBoxVisit2 = findViewById<CheckBox>(R.id.checkBoxVisit2)

        // Checkout button click listener
        findViewById<Button>(R.id.checkoutButton).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            var isHomeSelected = false

            if (checkBoxVisit1.isChecked) {
                intent.putExtra("homeName1", condoName1)
                intent.putExtra("homeAddress1", condoAddress1)
                intent.putExtra("homePrice1", condoPrice1)
                isHomeSelected = true
            }

            if (checkBoxVisit2.isChecked) {
                intent.putExtra("homeName2", condoName2)
                intent.putExtra("homeAddress2", condoAddress2)
                intent.putExtra("homePrice2", condoPrice2)
                isHomeSelected = true
            }

            if (isHomeSelected) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select at least one condominium apartment for visit", Toast.LENGTH_SHORT).show()
            }
        }

        // Back button click listener
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}
