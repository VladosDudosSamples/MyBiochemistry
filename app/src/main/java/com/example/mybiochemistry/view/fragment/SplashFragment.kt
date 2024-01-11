package com.example.mybiochemistry.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mybiochemistry.R
import com.example.mybiochemistry.app.App
import com.example.mybiochemistry.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private val binding: FragmentSplashBinding by lazy { FragmentSplashBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chooseFragment()
    }

    private fun chooseFragment(){
        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
    }
}