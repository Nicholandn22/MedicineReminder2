package com.example.medicinereminder.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R

class TambahObatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmment_tambah_obat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerJenisObat: Spinner = view.findViewById(R.id.spinnerJenisObat)
        val spinnerSatuanDosis: Spinner = view.findViewById(R.id.spinnerSatuanObat)

        val jenisObatList = arrayOf("Tablet", "Kapsul", "Sirup", "Salep", "Injeksi")
        val satuanDosisList = arrayOf("mg", "ml", "sdt", "sdm", "salep")

        activity?.let {
            val adapterJenisObat = ArrayAdapter(it, android.R.layout.simple_spinner_item, jenisObatList)
            adapterJenisObat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerJenisObat.adapter = adapterJenisObat
            adapterJenisObat.notifyDataSetChanged()

        }


        val adapterSatuanDosis = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, satuanDosisList)
        adapterSatuanDosis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSatuanDosis.adapter = adapterSatuanDosis

        spinnerJenisObat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                Toast.makeText(requireContext(), "Jenis Obat: ${jenisObatList[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinnerSatuanDosis.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                Toast.makeText(requireContext(), "Satuan Dosis: ${satuanDosisList[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}

