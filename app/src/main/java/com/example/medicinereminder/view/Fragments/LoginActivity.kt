package com.example.medicinereminder.view.Fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.medicinereminder.R
import com.example.medicinereminder.model.SessionManager
import com.example.medicinereminder.view.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        sessionManager = SessionManager(this)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            sessionManager.setLogin(true) // Simpan status login
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Tutup LoginActivity agar tidak bisa kembali
        }
    }

    fun onLoginSuccess() {
        val sessionManager = SessionManager(this)
        sessionManager.setLogin(true) // Simpan status login

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish() // Tutup LoginActivity agar tidak bisa kembali
    }

}
