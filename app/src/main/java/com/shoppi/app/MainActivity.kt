package com.shoppi.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnv = findViewById<BottomNavigationView>(R.id.navigation_main)
        bnv.itemIconTintList = null

        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bnv.setupWithNavController(it)
        }
    }
}