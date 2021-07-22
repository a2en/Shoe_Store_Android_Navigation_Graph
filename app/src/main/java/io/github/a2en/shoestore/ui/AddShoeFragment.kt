package io.github.a2en.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.github.a2en.shoestore.R
import io.github.a2en.shoestore.databinding.FragmentAddShoeBinding
import io.github.a2en.shoestore.model.Shoe


class AddShoeFragment : Fragment() {
    private lateinit var binding: FragmentAddShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddShoeBinding.inflate(inflater, container, false)
        (activity as androidx.appcompat.app.AppCompatActivity).setSupportActionBar(binding.toolbar)
        val appBarConfiguration = androidx.navigation.ui.AppBarConfiguration(findNavController().graph)
        androidx.navigation.ui.NavigationUI.setupActionBarWithNavController(requireActivity() as androidx.appcompat.app.AppCompatActivity, findNavController(),appBarConfiguration)
        binding.toolbar.title = getString(R.string.add_shoe)

        val model = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.cancel.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.save.setOnClickListener {
            if (verify()) {
                model.addShoe(Shoe(name = binding.editTextName.text.toString(),company = binding.editTextCompanyName.text.toString(),
                size = binding.editTextSize.text.toString(),description = binding.editTextDescription.text.toString()))
                activity?.onBackPressed()
            }else {
                Toast.makeText(requireContext(), "All fields are mandatory", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun verify(): Boolean {
        return binding.editTextName.text.isNotBlank() &&
                binding.editTextCompanyName.text.isNotBlank() &&
                binding.editTextDescription.text.isNotBlank() &&
                binding.editTextSize.text.isNotBlank();
    }

}