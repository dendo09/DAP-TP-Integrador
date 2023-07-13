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
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment() {

    val sharedViewModel : SharedViewModel by activityViewModels()
    private lateinit var newUserEditText: EditText
    private lateinit var newPassEditText: EditText
    private lateinit var confirmPassEditText: EditText
    private lateinit var regisConfirmButton: Button
    private lateinit var goBackButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)


        newUserEditText = view.findViewById(R.id.newUserEditText)
        newPassEditText = view.findViewById(R.id.newPassEditText)
        confirmPassEditText = view.findViewById(R.id.confirmPassEditText)
        regisConfirmButton = view.findViewById(R.id.regisConfirmButton)
        goBackButton = view.findViewById(R.id.backButton)

        regisConfirmButton.setOnClickListener {
            var newUser = newUserEditText.text.toString()
            var newPass = newPassEditText.text.toString()
            var confirmPass = confirmPassEditText.text.toString()

            if (newUser.isNotEmpty() && newPass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (newPass == confirmPass) {
                    if (sharedViewModel.checkExistence(newUser)) {
                        sharedViewModel.addUser(newUser, newPass)
                        Snackbar.make(requireView(), "Registration successful", Snackbar.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_registerFragment_to_logInFragment2)
                    } else {
                        Snackbar.make(requireView(), "Username already exists", Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    Snackbar.make(requireView(), "Passwords do not match", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Snackbar.make(requireView(), "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            }
        }

        goBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_logInFragment2)
        }

        return view
    }



}
