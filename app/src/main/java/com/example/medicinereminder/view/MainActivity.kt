package com.example.medicinereminder.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R
import com.example.medicinereminder.model.SessionManager
import com.example.medicinereminder.view.Fragments.*
import com.example.yourapp.ui.tambahpengingat.TambahPengingatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 Inisialisasi SessionManager
        sessionManager = SessionManager(this)

        // 🔹 Cek apakah user sudah login, jika tidak, pindah ke LoginActivity
        if (!sessionManager.isLoggedIn()) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Tutup MainActivity agar tidak bisa kembali
            return
        }
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab_add)
        bottomNav = findViewById(R.id.bottom_navigation)

        // FAB Click Listener untuk pindah ke Fragment Tambah
        fab.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            when (currentFragment) {
                is HomeFragment -> replaceFragment(TambahPengingatFragment())
                is ObatFragment -> replaceFragment(TambahObatFragment())
                is LansiaFragment -> replaceFragment(TambahLansiaFragment())
                else -> Toast.makeText(this, "Fragment tidak dikenali", Toast.LENGTH_SHORT).show()
            }
        }

        // Setup Bottom Navigation
        setupBottomNavigation()

        // Tambahkan listener untuk memantau perubahan fragment
        supportFragmentManager.addOnBackStackChangedListener {
            handleBackStackChange()
        }

        // Load Default Fragment (Home)
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_home
            replaceFragment(HomeFragment())
        }
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    updateFAB(R.drawable.plus_black)
                    toggleBottomNav(true) // Tampilkan bottom nav
                    true
                }
                R.id.nav_obat -> {
                    replaceFragment(ObatFragment())
                    updateFAB(R.drawable.pill)
                    toggleBottomNav(true) // Tampilkan bottom nav
                    true
                }
                R.id.nav_lansia -> {
                    replaceFragment(LansiaFragment())
                    updateFAB(R.drawable.user)
                    toggleBottomNav(true) // Tampilkan bottom nav
                    true
                }
                else -> false
            }
        }
    }

    private fun updateFAB(iconRes: Int) {
        fab.setImageResource(iconRes)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Agar bisa kembali ke fragment sebelumnya
            .commit()

        // Sembunyikan BottomNavigationView di halaman Tambah
        toggleBottomNav(fragment !is TambahPengingatFragment &&
                fragment !is TambahObatFragment &&
                fragment !is TambahLansiaFragment)
    }

    /**
     * Menampilkan atau menyembunyikan BottomNavigationView dan FAB
     */
    private fun toggleBottomNav(show: Boolean) {
        bottomNav.visibility = if (show) View.VISIBLE else View.GONE
        fab.visibility = if (show) View.VISIBLE else View.GONE // FAB juga disembunyikan di halaman tambah
    }

    /**
     * Mengecek fragment yang sedang aktif, jika kembali ke Home/Lansia/Obat, maka bottom nav & FAB muncul lagi.
     */
    private fun handleBackStackChange() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        toggleBottomNav(currentFragment is HomeFragment ||
                currentFragment is LansiaFragment ||
                currentFragment is ObatFragment)
    }

    // 🔹 Tambahkan menu logout
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


}
