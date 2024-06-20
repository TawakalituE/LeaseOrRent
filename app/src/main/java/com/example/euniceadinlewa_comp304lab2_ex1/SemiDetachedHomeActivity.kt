package com.example.euniceadinlewa_comp304lab2_ex1


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SemiDetachedHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semi_detached_home)

        val semiDetachedName1 = "Semi-Detached Home 1"
        val semiDetachedAddress1 = "654 Elm St, Springfield"
        val semiDetachedPrice1 = "$2000/month"

        val semiDetachedName2 = "Semi-Detached Home 2"
        val semiDetachedAddress2 = "987 Birch St, Springfield"
        val semiDetachedPrice2 = "$2200/month"

        // Text views for first semi-detached home
        val textViewSemiDetachedName1 = findViewById<TextView>(R.id.textViewSemiDetachedName1)
        val textViewSemiDetachedAddress1 = findViewById<TextView>(R.id.textViewSemiDetachedAddress1)
        val textViewSemiDetachedPrice1 = findViewById<TextView>(R.id.textViewSemiDetachedPrice1)

        textViewSemiDetachedName1.text = semiDetachedName1
        textViewSemiDetachedAddress1.text = semiDetachedAddress1
        textViewSemiDetachedPrice1.text = semiDetachedPrice1

        // Image view for first semi-detached home
        val imageViewSemiDetached1 = findViewById<ImageView>(R.id.imageViewSemiDetached1)
        imageViewSemiDetached1.setImageResource(R.drawable.semi_detached_home_image)

        // Text views for second semi-detached home
        val textViewSemiDetachedName2 = findViewById<TextView>(R.id.textViewSemiDetachedName2)
        val textViewSemiDetachedAddress2 = findViewById<TextView>(R.id.textViewSemiDetachedAddress2)
        val textViewSemiDetachedPrice2 = findViewById<TextView>(R.id.textViewSemiDetachedPrice2)

        textViewSemiDetachedName2.text = semiDetachedName2
        textViewSemiDetachedAddress2.text = semiDetachedAddress2
        textViewSemiDetachedPrice2.text = semiDetachedPrice2

        // Image view for second semi-detached home
        val imageViewSemiDetached2 = findViewById<ImageView>(R.id.imageViewSemiDetached2)
        imageViewSemiDetached2.setImageResource(R.drawable.semidetached2)

        // Checkboxes
        val checkBoxVisit1 = findViewById<CheckBox>(R.id.checkBoxVisit1)
        val checkBoxVisit2 = findViewById<CheckBox>(R.id.checkBoxVisit2)

        // Checkout button click listener
        findViewById<Button>(R.id.checkoutButton).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            var isHomeSelected = false

            if (checkBoxVisit1.isChecked) {
                intent.putExtra("homeName1", semiDetachedName1)
                intent.putExtra("homeAddress1", semiDetachedAddress1)
                intent.putExtra("homePrice1", semiDetachedPrice1)
                isHomeSelected = true
            }

            if (checkBoxVisit2.isChecked) {
                intent.putExtra("homeName2", semiDetachedName2)
                intent.putExtra("homeAddress2", semiDetachedAddress2)
                intent.putExtra("homePrice2", semiDetachedPrice2)
                isHomeSelected = true
            }

            if (isHomeSelected) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select at least one semi-detached home for visit", Toast.LENGTH_SHORT).show()
            }
        }

        // Back button click listener
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}
