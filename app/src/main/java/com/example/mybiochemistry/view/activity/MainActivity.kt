package com.example.mybiochemistry.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybiochemistry.R
import com.example.mybiochemistry.app.App
import com.example.mybiochemistry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLogin()
    }
    private fun checkLogin(){
        if (App.dm.isLoginPassed()) startActivity(Intent(this, DrawerActivity::class.java))
    }
}