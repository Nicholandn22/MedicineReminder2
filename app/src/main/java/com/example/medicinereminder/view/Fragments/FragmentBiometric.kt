package com.example.medicinereminder.view.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R
import com.example.medicinereminder.model.SessionManager
import com.example.medicinereminder.view.MainActivity

class FragmentBiometric : Fragment() {
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_biometric, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi SessionManager
        sessionManager = SessionManager(requireContext())

        // Menginisialisasi ImageView untuk sidik jari dan wajah
        val btnMuka = view.findViewById<ImageView>(R.id.btn_muka)
        btnMuka.setOnClickListener {
            sessionManager.setLogin(true) // Simpan status login
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish() // Tutup LoginActivity agar tidak bisa kembali
        }

        val btnSidikJari = view.findViewById<ImageView>(R.id.btn_sidikjari)
        btnSidikJari.setOnClickListener {
            sessionManager.setLogin(true) // Simpan status login
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish() // Tutup LoginActivity agar tidak bisa kembali
        }
    }
}