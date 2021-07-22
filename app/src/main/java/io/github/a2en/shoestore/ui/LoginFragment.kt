package io.github.a2en.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import io.github.a2en.shoestore.R
import io.github.a2en.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  FragmentLoginBinding.inflate(inflater,container,false)
        binding.loginBtn.setOnClickListener {
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.signUpBtn.setOnClickListener {
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        return binding.root
    }

}