package com.example.finaldap

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PantallaLogin : Fragment() {

    companion object {
        fun newInstance() = PantallaLogin()
    }

    private lateinit var viewModel: PantallaLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pantalla_login, container, false)

        return view
    }

}