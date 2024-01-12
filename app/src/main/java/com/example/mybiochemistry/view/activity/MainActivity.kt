package com.example.mybiochemistry.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}