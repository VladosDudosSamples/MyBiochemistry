package com.example.mybiochemistry.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.FragmentRegistrationBinding
import com.example.mybiochemistry.databinding.FragmentSplashBinding


class RegistrationFragment : Fragment() {

    private val binding: FragmentRegistrationBinding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick(){
        binding.authorisationButton.setOnClickListener { findNavController().popBackStack() }
    }
}