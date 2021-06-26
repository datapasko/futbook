package com.futbook.auth.infrastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.futbook.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}