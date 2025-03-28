package com.example.yourapp.ui.tambahpengingat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R


class TambahPengingatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tambah_pengingat, container, false)

        // Inisialisasi View
        val btnBack: ImageView = view.findViewById(R.id.btnBack)
        val tvNamaLansia: TextView = view.findViewById(R.id.tvNamaLansia)
        val spinnerPengulangan: Spinner = view.findViewById(R.id.spinnerPengulangan)
        val spinnerNadaDering: Spinner = view.findViewById(R.id.spinnerNadaDering)
        val btnSave: Button = view.findViewById(R.id.btnSave)
        val btnCancel: Button = view.findViewById(R.id.btnCancel)

        // Event Listener
        btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        btnCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }

        btnSave.setOnClickListener {
            // Tambahkan logika penyimpanan pengingat di sini
        }


        return view
    }
}