package com.futbook.splash.infrastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.futbook.R
import com.futbook.auth.infrastructure.AuthActivity
import com.futbook.players.infrastructure.IndexPlayerActivity
import com.futbook.users.domain.UserPreferences
import com.futbook.util.startNewActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userPreferences = UserPreferences(this)

        userPreferences.accessToken.asLiveData().observe(this, Observer {
            val activity = if(it == null) AuthActivity::class.java else IndexPlayerActivity::class.java
            startNewActivity(activity)
        })
    }
}