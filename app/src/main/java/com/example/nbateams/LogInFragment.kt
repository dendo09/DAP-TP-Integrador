package com.example.nbateams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.nbateams.R
import com.google.android.material.snackbar.Snackbar

class LogInFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedViewModel : SharedViewModel by activityViewModels()
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)
        val loginButton = view.findViewById<Button>(R.id.logInButton)
        val registerButton = view.findViewById<Button>(R.id.regisButton)
        val userEditText = view.findViewById<EditText>(R.id.userEditText)
        val passEditText = view.findViewById<EditText>(R.id.passEditText)

        sharedViewModel.addUser("admin", "admin")

        loginButton.setOnClickListener {
            val userEntered: String = userEditText.text.toString()
            val passEntered: String = passEditText.text.toString()


            if(userEntered.isEmpty() || passEntered.isEmpty()){
                Snackbar.make(view, "Please enter both username and password", Snackbar.LENGTH_SHORT).show()
            }
            else if(sharedViewModel.checkCredentials(userEntered, passEntered)){
                Snackbar.make(view, "Login successful", Snackbar.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_logInFragment_to_listFragment)
            }
            else{
                Snackbar.make(view, "Invalid username or password", Snackbar.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_registerFragment)
        }
        return view

    }


}