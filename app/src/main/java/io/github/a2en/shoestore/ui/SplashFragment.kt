package io.github.a2en.shoestore.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import io.github.a2en.shoestore.R


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler(Looper.getMainLooper()).postDelayed({
                view?.findNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        },2000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}