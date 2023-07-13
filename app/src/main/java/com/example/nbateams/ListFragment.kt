package com.example.nbateams

import adapter.TeamAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }
    val sharedViewModel : SharedViewModel by activityViewModels()
    private lateinit var v : View
    private lateinit var recTeams : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        recTeams = v.findViewById(R.id.recTeams)
        return v
    }

    override fun onStart() {
        super.onStart()

        recTeams.setHasFixedSize(true)

        recTeams.layoutManager  = LinearLayoutManager(context)

        recTeams.adapter = TeamAdapter(sharedViewModel.getTeams()) { teams ->
            sharedViewModel.itemSelected = teams
            findNavController().navigate(R.id.action_listFragment_to_infoFragment)

        }
    }
}