package com.example.mybiochemistry.view.fragment

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.ActivityMainBinding
import com.example.mybiochemistry.databinding.FragmentMainBinding
import java.text.SimpleDateFormat
import com.example.mybiochemistry.view.activity.MainActivity
import com.example.mybiochemistry.viewmodel.MainFragmentViewModel
import java.util.Date


class MainFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by viewModels()
    private val binding: FragmentMainBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private val format = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        visualFix()
        setObservers()
        viewModel.getSubscribeInfo()
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
    private fun setObservers(){
        viewModel.currentUser.observe(viewLifecycleOwner){
            with(binding){
                activationText.setText(if (format.parse(viewModel.currentUser.value!!.subscribeDate)!!.before(Date())) resources.getString(R.string.is_not_active) else resources.getString(R.string.activated))
                dateOfSubscribe.text = viewModel.currentUser.value!!.subscribeDate.replace("/", ".")
            }
        }
    }
}