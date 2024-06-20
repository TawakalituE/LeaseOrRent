package com.example.euniceadinlewa_comp304lab2_ex1


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeTypesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_types)

        findViewById<Button>(R.id.buttonApartment).setOnClickListener {
            startActivity(Intent(this, ApartmentActivity::class.java))
        }
        findViewById<Button>(R.id.buttonDetachedHome).setOnClickListener {
            startActivity(Intent(this, DetachedHomeActivity::class.java))
        }
        findViewById<Button>(R.id.buttonSemiDetachedHome).setOnClickListener {
            startActivity(Intent(this, SemiDetachedHomeActivity::class.java))
        }
        findViewById<Button>(R.id.buttonCondominiumApartment).setOnClickListener {
            startActivity(Intent(this, CondominiumApartmentActivity::class.java))
        }
        findViewById<Button>(R.id.buttonTownHouse).setOnClickListener {
            startActivity(Intent(this, TownHouseActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_apartment -> {
                startActivity(Intent(this, ApartmentActivity::class.java))
                true
            }
            R.id.menu_detached_home -> {
                startActivity(Intent(this, DetachedHomeActivity::class.java))
                true
            }
            R.id.menu_semi_detached_home -> {
                startActivity(Intent(this, SemiDetachedHomeActivity::class.java))
                true
            }
            R.id.menu_condominium_apartment -> {
                startActivity(Intent(this, CondominiumApartmentActivity::class.java))
                true
            }
            R.id.menu_town_house -> {
                startActivity(Intent(this, TownHouseActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
