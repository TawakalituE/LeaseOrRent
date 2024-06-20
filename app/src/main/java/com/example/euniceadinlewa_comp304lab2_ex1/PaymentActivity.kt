package com.example.euniceadinlewa_comp304lab2_ex1


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Retrieve home details from Intent
        val homeName = intent.getStringExtra("homeName") ?: "No Home Selected"
        val homeAddress = intent.getStringExtra("homeAddress") ?: "No Address Provided"
        val homePrice = intent.getStringExtra("homePrice") ?: "No Price Listed"

        // Text view to display payment details
        findViewById<TextView>(R.id.textViewPaymentDetails).text = "Payment Details for $homeName"

        // Submit payment button click listener
        findViewById<Button>(R.id.buttonSubmitPayment).setOnClickListener {
            val fullName = findViewById<EditText>(R.id.editTextFullName).text.toString().trim()
            val cardNumber = findViewById<EditText>(R.id.editTextCardNumber).text.toString().trim()
            val favoriteSport = findViewById<EditText>(R.id.editTextFavoriteSport).text.toString().trim()
            val favoriteTeam = findViewById<EditText>(R.id.editTextFavoriteTeam).text.toString().trim()
            val favoriteFood = findViewById<EditText>(R.id.editTextFavoriteFood).text.toString().trim()

            val radioGroupPaymentMethod = findViewById<RadioGroup>(R.id.radioGroupPaymentMethod)
            val selectedPaymentId = radioGroupPaymentMethod.checkedRadioButtonId
            val selectedPaymentMethod = findViewById<RadioButton>(selectedPaymentId)?.text.toString()

            if (fullName.isEmpty() || cardNumber.isEmpty() || selectedPaymentMethod.isEmpty() ||
                favoriteSport.isEmpty() || favoriteTeam.isEmpty() || favoriteFood.isEmpty()) {
                showToast("Please fill all required fields and select a payment method")
            } else {
                processPayment(fullName, cardNumber, selectedPaymentMethod, homeName, homeAddress, homePrice, favoriteSport, favoriteTeam, favoriteFood)
            }
        }
    }

    private fun processPayment(
        fullName: String,
        cardNumber: String,
        paymentMethod: String,
        homeName: String,
        homeAddress: String,
        homePrice: String,
        favoriteSport: String,
        favoriteTeam: String,
        favoriteFood: String
    ) {
        val resultIntent = Intent().apply {
            putExtra("paymentMethod", paymentMethod)
            putExtra("fullName", fullName)
            putExtra("cardNumber", cardNumber)
            putExtra("favoriteSport", favoriteSport)
            putExtra("favoriteTeam", favoriteTeam)
            putExtra("favoriteFood", favoriteFood)
            putExtra("homeName", homeName) // Include home details
            putExtra("homeAddress", homeAddress) // Include home details
            putExtra("homePrice", homePrice) // Include home details
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
