package io.github.a2en.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import io.github.a2en.shoestore.R


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false).apply {
            findViewById<Button>(R.id.next)?.setOnClickListener {
                view?.findNavController()
                    ?.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
            }
        }
    }

}