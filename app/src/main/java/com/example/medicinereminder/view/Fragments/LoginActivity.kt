package com.example.medicinereminder.view.Fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R
import com.example.medicinereminder.model.SessionManager
import com.example.medicinereminder.view.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login) // Pastikan ini adalah layout yang benar

        sessionManager = SessionManager(this)

        // Mengakses tombol setelah layout di-inflate
        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            sessionManager.setLogin(true) // Simpan status login
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Tutup LoginActivity agar tidak bisa kembali
        }

        val btnRegister = findViewById<Button>(R.id.register)
        btnRegister.setOnClickListener {
            val signUpFragment = SignUpFragment()

            // Ganti fragment yang ada dengan fragment baru
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, signUpFragment, SignUpFragment::class.java.simpleName)

            // Menambahkan transaksi ini ke back stack agar bisa kembali ke fragment sebelumnya
            transaction.addToBackStack(null)

            // Commit transaksi untuk menambahkan fragment
            transaction.commit()
        }

        val btnBiometric = findViewById<Button>(R.id.btn_biometric)
        btnBiometric.setOnClickListener {
            val biometricFragment = FragmentBiometric()

            // Ganti fragment yang ada dengan fragment baru
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, biometricFragment, FragmentBiometric::class.java.simpleName)

            // Menambahkan transaksi ini ke back stack agar bisa kembali ke fragment sebelumnya
            transaction.addToBackStack(null)

            // Commit transaksi untuk menambahkan fragment
            transaction.commit()
        }

        val btn_forgetPass = findViewById<Button>(R.id.btn_forgetPass)
        btn_forgetPass.setOnClickListener {
            val biometricFragment = FragmentForgetPas()

            // Ganti fragment yang ada dengan fragment baru
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, biometricFragment, FragmentBiometric::class.java.simpleName)

            // Menambahkan transaksi ini ke back stack agar bisa kembali ke fragment sebelumnya
            transaction.addToBackStack(null)

            // Commit transaksi untuk menambahkan fragment
            transaction.commit()
        }

        // Menampilkan LoginFragment pertama kali
        if (savedInstanceState == null) {
            val loginFragment = LoginFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit()
        }
    }

    fun onLoginSuccess() {
        sessionManager.setLogin(true) // Simpan status login

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish() // Tutup LoginActivity agar tidak bisa kembali
    }
}