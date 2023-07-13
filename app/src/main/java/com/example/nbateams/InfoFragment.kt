package com.example.nbateams

import adapter.TeamAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class InfoFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_info, container, false)
        val textTitle = v.findViewById<TextView>(R.id.infoTitle)
        val textConference = v.findViewById<TextView>(R.id.infoConference)
        val textState = v.findViewById<TextView>(R.id.infoState)
        val textMvp = v.findViewById<TextView>(R.id.infoMvp)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val team = sharedViewModel.itemSelected

        textTitle.text = team.name
        textConference.text = team.conference
        textState.text = team.state
        textMvp.text = team.mvp

        return v
    }
}

