package com.example.medicinereminder.view.Fragments


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.medicinereminder.R
import com.example.medicinereminder.view.Fragments.LoginActivity
import com.example.medicinereminder.view.MainActivity

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val btnLogin = view.findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val activity = requireActivity() as? LoginActivity
            activity?.onLoginSuccess()
        }

        return view
    }
}

