package com.futbook.clubs.infrastructure.show

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.children
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.futbook.R
import com.futbook.databinding.ActivityShowClubBinding
import com.google.android.material.navigation.NavigationView
import org.jetbrains.anko.appcompat.v7.listMenuItemView

class ShowClubActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityShowClubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowClubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout = binding.drawerShowClub
        val navView = binding.navigationViewClub
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbar, R.string.open_navigation_drawer, R.string.closed_navigation_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        with(binding){


        }

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = binding.drawerShowClub
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

        }
        val drawerLayout: DrawerLayout = binding.drawerShowClub
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}