package com.example.mybiochemistry.view.fragment

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.ActivityMainBinding
import com.example.mybiochemistry.databinding.FragmentMainBinding
import com.example.mybiochemistry.view.activity.MainActivity


class MainFragment : Fragment() {
    private val binding: FragmentMainBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        visualFix()
        onClick()
    }

    private fun visualFix(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.mainImage.setRenderEffect(RenderEffect.createBlurEffect(4F,4F, Shader.TileMode.MIRROR))
        }
    }

    private fun onClick(){
        binding.nextButton.setOnClickListener { findNavController().navigate(R.id.action_mainFragment_to_listMoleculeFragment) }
    }
}