package com.example.mybiochemistry.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.FragmentListMoleculeBinding


class ListMoleculeFragment : Fragment() {

    private val binding: FragmentListMoleculeBinding by lazy { FragmentListMoleculeBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}