package com.example.mybiochemistry.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.FragmentListMoleculeBinding
import com.example.mybiochemistry.utils.Destination
import com.example.mybiochemistry.view.adapter.ListMoleculeAdapter


class ListMoleculeFragment : Fragment() {

    private val binding: FragmentListMoleculeBinding by lazy { FragmentListMoleculeBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        setAdapter()
    }
    private fun onClick(){

    }
    private fun setAdapter(){
        binding.rvListBio.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rvListBio.adapter = ListMoleculeAdapter(requireContext(), Destination.listParts)
    }
}