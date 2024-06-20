package com.example.euniceadinlewa_comp304lab2_ex1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class CheckoutActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_PAYMENT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // Retrieve home details from Intent
        val homeName1 = intent.getStringExtra("homeName1")
        val homeAddress1 = intent.getStringExtra("homeAddress1")
        val homePrice1 = intent.getStringExtra("homePrice1")

        val homeName2 = intent.getStringExtra("homeName2")
        val homeAddress2 = intent.getStringExtra("homeAddress2")
        val homePrice2 = intent.getStringExtra("homePrice2")

        // Radio group with the selected homes
        val radioGroupHomes = findViewById<RadioGroup>(R.id.radioGroupHomes)

        if (homeName1 != null && homeAddress1 != null && homePrice1 != null) {
            val radioButton1 = RadioButton(this).apply {
                text = "Home 1: $homeName1\nAddress: $homeAddress1\nPrice: $homePrice1"
                id = View.generateViewId()
            }
            radioButton1.tag = "home1"
            radioGroupHomes.addView(radioButton1)
        }

        if (homeName2 != null && homeAddress2 != null && homePrice2 != null) {
            val radioButton2 = RadioButton(this).apply {
                text = "Home 2: $homeName2\nAddress: $homeAddress2\nPrice: $homePrice2"
                id = View.generateViewId()
            }
            radioButton2.tag = "home2"
            radioGroupHomes.addView(radioButton2)
        }

        //  Proceed to Payment button click listener
        findViewById<Button>(R.id.buttonProceedToPayment).setOnClickListener {
            val selectedHomeId = radioGroupHomes.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedHomeId)
            val intent = Intent(this, PaymentActivity::class.java)

            when (selectedRadioButton?.tag) {
                "home1" -> {
                    intent.putExtra("homeName", homeName1)
                    intent.putExtra("homeAddress", homeAddress1)
                    intent.putExtra("homePrice", homePrice1)
                }
                "home2" -> {
                    intent.putExtra("homeName", homeName2)
                    intent.putExtra("homeAddress", homeAddress2)
                    intent.putExtra("homePrice", homePrice2)
                }
                else -> {
                    // No home selected, show a message or handle accordingly
                    return@setOnClickListener
                }
            }

            startActivityForResult(intent, REQUEST_PAYMENT)
        }

        // Set up Back to Home Types button click listener
        findViewById<Button>(R.id.buttonBackToHome).setOnClickListener {
            startActivity(Intent(this, HomeTypesActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_PAYMENT && resultCode == RESULT_OK) {
            val paymentMethod = data?.getStringExtra("paymentMethod") ?: "N/A"
            val fullName = data?.getStringExtra("fullName") ?: "N/A"
            val cardNumber = data?.getStringExtra("cardNumber") ?: "N/A"

            val homeName = data?.getStringExtra("homeName")
            val homeAddress = data?.getStringExtra("homeAddress")
            val homePrice = data?.getStringExtra("homePrice")

            val intent = Intent(this, FinalOrderActivity::class.java).apply {
                putExtra("homeName", homeName)
                putExtra("homeAddress", homeAddress)
                putExtra("homePrice", homePrice)
                putExtra("paymentMethod", paymentMethod)
                putExtra("fullName", fullName)
                putExtra("cardNumber", cardNumber)
            }
            startActivity(intent)
        }
    }
}

