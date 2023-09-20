package com.example.age_calculation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.age_calculation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login.text.toString()
        val email = binding.userEt.text.toString()
        val password = binding.passWordEt.text.toString()
        loginButton.setOnClickListener {
            if(email.isNotEmpty() && password.isNotEmpty()){
                val navDirection = LoginFragmentDirections.actionLoginFragmentToAppFragment2()
                val navController = view?.findNavController()
                navController?.navigate(navDirection)
            }
        }
    }
}
