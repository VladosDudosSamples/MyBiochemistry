package com.example.mybiochemistry.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.core.view.GravityCompat
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.ActivityDrawerBinding
import com.example.mybiochemistry.utils.Destination.isDrawerGraph

class DrawerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_drawer) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
        isDrawerGraph = true
        setObservers()
        onClick()
    }
    private fun onClick(){
        with(binding) {
            drawerButton.setOnClickListener {
                openDrawer()
            }

        }
    }
    private fun setObservers(){

    }
    private fun openDrawer() {
        binding.root.openDrawer(GravityCompat.START)
    }
}