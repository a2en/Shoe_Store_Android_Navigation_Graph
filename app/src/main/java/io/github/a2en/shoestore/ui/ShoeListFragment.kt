package io.github.a2en.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import io.github.a2en.shoestore.R
import io.github.a2en.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShoeListBinding.inflate(inflater,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.shoeListFragment, R.id.addShoeFragment))
        NavigationUI.setupActionBarWithNavController(requireActivity() as AppCompatActivity, findNavController(),appBarConfiguration)
        binding.toolbar.title = getString(R.string.app_name)

        val model = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        model.shoes.observe(viewLifecycleOwner, { list ->
            binding.listItem.adapter = ShoeAdapter(list)
        })

        binding.fab.setOnClickListener {
            view?.findNavController()?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }

        return binding.root
    }



}