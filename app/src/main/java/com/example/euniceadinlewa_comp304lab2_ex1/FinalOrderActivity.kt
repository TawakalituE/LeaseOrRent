package com.example.euniceadinlewa_comp304lab2_ex1


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FinalOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_order)

        // Retrieve data from Intent
        val homeName = intent.getStringExtra("homeName") ?: "No Home Selected"
        val homeAddress = intent.getStringExtra("homeAddress") ?: "No Address Provided"
        val homePrice = intent.getStringExtra("homePrice") ?: "No Price Listed"
        val paymentMethod = intent.getStringExtra("paymentMethod") ?: "N/A"
        val fullName = intent.getStringExtra("fullName") ?: "N/A"
        val cardNumber = intent.getStringExtra("cardNumber") ?: "N/A"

        // Display home details
        findViewById<TextView>(R.id.textViewHomeDetails).text =
            "Home Name: $homeName\nAddress: $homeAddress\nPrice: $homePrice"

        // Display payment details
        findViewById<TextView>(R.id.textViewPaymentDetails).text =
            "Payment Method: $paymentMethod\nPaid by: $fullName\nCard Number: $cardNumber"

        //  Confirm Order button click listener
        findViewById<Button>(R.id.buttonConfirmOrder).setOnClickListener {
            // Handle final order confirmation logic here
            showToast("Order confirmed! Thank you for choosing LeaseOrRentHome Inc.")

            finish()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
