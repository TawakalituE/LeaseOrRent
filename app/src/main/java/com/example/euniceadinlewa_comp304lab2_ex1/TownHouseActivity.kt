package com.example.euniceadinlewa_comp304lab2_ex1


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TownHouseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town_house)

        val townHouseName1 = "Cozy Townhouse 1"
        val townHouseAddress1 = "101 Main St, Springfield"
        val townHousePrice1 = "$1100/month"

        val townHouseName2 = "Cozy Townhouse 2"
        val townHouseAddress2 = "202 Maple St, Springfield"
        val townHousePrice2 = "$1200/month"

        // Text views for first townhouse
        val textViewTownHouseName1 = findViewById<TextView>(R.id.textViewTownHouseName1)
        val textViewTownHouseAddress1 = findViewById<TextView>(R.id.textViewTownHouseAddress1)
        val textViewTownHousePrice1 = findViewById<TextView>(R.id.textViewTownHousePrice1)

        textViewTownHouseName1.text = townHouseName1
        textViewTownHouseAddress1.text = townHouseAddress1
        textViewTownHousePrice1.text = townHousePrice1

        // Image view for first townhouse
        val imageViewTownHouse1 = findViewById<ImageView>(R.id.imageViewTownHouse1)
        imageViewTownHouse1.setImageResource(R.drawable.town_house_image)

        // Text views for second townhouse
        val textViewTownHouseName2 = findViewById<TextView>(R.id.textViewTownHouseName2)
        val textViewTownHouseAddress2 = findViewById<TextView>(R.id.textViewTownHouseAddress2)
        val textViewTownHousePrice2 = findViewById<TextView>(R.id.textViewTownHousePrice2)

        textViewTownHouseName2.text = townHouseName2
        textViewTownHouseAddress2.text = townHouseAddress2
        textViewTownHousePrice2.text = townHousePrice2

        // Image view for second townhouse
        val imageViewTownHouse2 = findViewById<ImageView>(R.id.imageViewTownHouse2)
        imageViewTownHouse2.setImageResource(R.drawable.townhouse2)

        // Checkboxes
        val checkBoxVisit1 = findViewById<CheckBox>(R.id.checkBoxVisit1)
        val checkBoxVisit2 = findViewById<CheckBox>(R.id.checkBoxVisit2)

        // Checkout button click listener
        findViewById<Button>(R.id.checkoutButton).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            var isHomeSelected = false

            if (checkBoxVisit1.isChecked) {
                intent.putExtra("homeName1", townHouseName1)
                intent.putExtra("homeAddress1", townHouseAddress1)
                intent.putExtra("homePrice1", townHousePrice1)
                isHomeSelected = true
            }

            if (checkBoxVisit2.isChecked) {
                intent.putExtra("homeName2", townHouseName2)
                intent.putExtra("homeAddress2", townHouseAddress2)
                intent.putExtra("homePrice2", townHousePrice2)
                isHomeSelected = true
            }

            if (isHomeSelected) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select at least one townhouse for visit", Toast.LENGTH_SHORT).show()
            }
        }

        // Back button click listener
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}
