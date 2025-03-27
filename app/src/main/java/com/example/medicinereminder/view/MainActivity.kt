package com.example.medicinereminder.view

import com.example.medicinereminder.view.Fragments.HomeFragment
import com.example.medicinereminder.view.Fragments.LansiaFragment
import com.example.medicinereminder.view.Fragments.ObatFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> openFragment(HomeFragment())
                R.id.nav_lansia -> openFragment(LansiaFragment())
                R.id.nav_obat -> openFragment(ObatFragment())
            }
            true
        }

        // Load default fragment
        openFragment(HomeFragment())
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }


}