package com.futbook.clubs.infrastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.futbook.clubs.domain.Club
import com.futbook.databinding.ActivityClubsBinding

class ClubsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClubsBinding

    private lateinit var viewModel: ClubsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ClubsViewModel::class.java)

        val clubsObserver = Observer<List<Club>>{
            for (club in it){
                Log.d("messi", club.name)
            }
        }

        viewModel.getListClubsLiveData().observe(this, clubsObserver)

        with(binding){


        }
    }
}