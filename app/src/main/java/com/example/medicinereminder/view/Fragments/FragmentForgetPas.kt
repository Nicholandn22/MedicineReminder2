package com.example.medicinereminder.view.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R
import com.example.medicinereminder.databinding.FragmentBiometricBinding

class FragmentForgetPas : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getLayoutInflater().inflate(R.layout.fragments_forget_pass, container, false)
    }
}