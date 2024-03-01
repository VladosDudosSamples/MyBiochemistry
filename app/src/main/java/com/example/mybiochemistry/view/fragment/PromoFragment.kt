package com.example.mybiochemistry.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.FragmentPromoBinding

class PromoFragment : Fragment() {

    private val binding: FragmentPromoBinding by lazy { FragmentPromoBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}