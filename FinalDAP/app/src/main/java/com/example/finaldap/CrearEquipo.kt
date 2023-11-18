package com.example.finaldap

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CrearEquipo : Fragment() {

    companion object {
        fun newInstance() = CrearEquipo()
    }

    private lateinit var viewModel: CrearEquipoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crear_equipo, container, false)

        return view
    }

}