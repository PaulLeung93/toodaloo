package com.myapplication.toodaloo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        val mapFragment: Fragment = MapFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener{item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.nav_map -> fragment = mapFragment
            }
            fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
            true
        }

        bottomNavigationView.selectedItemId = R.id.nav_map
    }
}