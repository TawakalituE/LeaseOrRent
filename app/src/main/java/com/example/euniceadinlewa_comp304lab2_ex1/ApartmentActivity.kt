package com.example.euniceadinlewa_comp304lab2_ex1

import android.content.Intent
import android.widget.ImageView
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ApartmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apartment)

        val apartmentName1 = "Luxury Apartment 1"
        val apartmentAddress1 = "123 Main St, Springfield"
        val apartmentPrice1 = "$1200/month"

        val apartmentName2 = "Luxury Apartment 2"
        val apartmentAddress2 = "456 Oak St, Springfield"
        val apartmentPrice2 = "$1500/month"

        // Text views for first apartment
        findViewById<TextView>(R.id.textViewApartmentName1).text = apartmentName1
        findViewById<TextView>(R.id.textViewApartmentAddress1).text = apartmentAddress1
        findViewById<TextView>(R.id.textViewApartmentPrice1).text = apartmentPrice1

        // Image view for first apartment
        findViewById<ImageView>(R.id.imageViewApartment1).setImageResource(R.drawable.new_rental_apartment)

        // Text views for second apartment
        findViewById<TextView>(R.id.textViewApartmentName2).text = apartmentName2
        findViewById<TextView>(R.id.textViewApartmentAddress2).text = apartmentAddress2
        findViewById<TextView>(R.id.textViewApartmentPrice2).text = apartmentPrice2

        // Image view for second apartment
        findViewById<ImageView>(R.id.imageViewApartment2).setImageResource(R.drawable.apartment2)

        //  Checkboxes
        val checkBoxVisit1 = findViewById<CheckBox>(R.id.checkBoxVisit1)
        val checkBoxVisit2 = findViewById<CheckBox>(R.id.checkBoxVisit2)

        // Checkout button click listener
        findViewById<Button>(R.id.checkoutButton).setOnClickListener {
            if (checkBoxVisit1.isChecked || checkBoxVisit2.isChecked) {
                val intent = Intent(this, CheckoutActivity::class.java)
                if (checkBoxVisit1.isChecked) {
                    intent.putExtra("homeName1", apartmentName1)
                    intent.putExtra("homeAddress1", apartmentAddress1)
                    intent.putExtra("homePrice1", apartmentPrice1)
                }
                if (checkBoxVisit2.isChecked) {
                    intent.putExtra("homeName2", apartmentName2)
                    intent.putExtra("homeAddress2", apartmentAddress2)
                    intent.putExtra("homePrice2", apartmentPrice2)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select at least one apartment for visit", Toast.LENGTH_SHORT).show()
            }
        }

        // Back button click listener
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}
