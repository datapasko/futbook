package com.futbook.players.infrastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.futbook.R
import com.futbook.databinding.ActivityIndexPlayerBinding
import com.google.android.material.navigation.NavigationView
import org.jetbrains.anko.toast

class IndexPlayerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityIndexPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarIndexPlayer
        setSupportActionBar(toolbar)
        toolbar.title = "Daniel"

        val drawerLayout = binding.drawerIndexPlayer
        val navView = binding.navigationViewIndexPlayer
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbarIndexPlayer ,
            R.string.open_navigation_drawer, R.string.closed_navigation_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        changeMenuDrawer(navView, false)

        with(binding){

            fabCreateClub.setOnClickListener { toast(" crar club") }

        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val menu = binding.navigationViewIndexPlayer.menu

        when (item.itemId) {

            menu[0].itemId -> {
                toast("mi perfil")
            }

            menu[1].itemId -> {
                toast("mi clubes")
            }

            menu[2].itemId -> {
                toast("mi partidos")
            }

            menu[3].itemId -> {
                toast("mi cv")
            }

            menu[4].itemId -> {
                toast("club")
            }

        }

        val drawerLayout = binding.drawerIndexPlayer
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = binding.drawerIndexPlayer
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

        }
    }

    private fun changeMenuDrawer (navigationView: NavigationView, condition: Boolean) {

        if(condition)
            navigationView.menu.getItem(4).isVisible = false

    }
}

