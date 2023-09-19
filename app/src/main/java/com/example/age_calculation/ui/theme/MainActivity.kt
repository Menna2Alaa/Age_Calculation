package com.example.age_calculation.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.age_calculation.R
import com.example.age_calculation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar : Toolbar
    private lateinit var slider : NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this,R.id.Nav_Host)

        toolbar = binding.toolbar
        val fragments :MutableSet<Int> = HashSet()
        fragments.add(R.id.loginFragment)
        fragments.add(R.id.appFragment)
        fragments.add(R.id.birthFragment)
        fragments.add(R.id.dateFragment)
        drawerLayout = binding.drawerLayout
        appBarConfiguration = AppBarConfiguration.Builder().setOpenableLayout(drawerLayout).build()
        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration)

        slider=binding.slider
        NavigationUI.setupWithNavController(slider,navController)



    }
}
