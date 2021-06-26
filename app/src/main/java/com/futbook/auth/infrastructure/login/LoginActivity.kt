package com.futbook.auth.infrastructure.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.futbook.auth.infrastructure.register.RegisterActivity
import com.futbook.databinding.ActivityLoginBinding
import com.futbook.players.infrastructure.IndexPlayerActivity
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnLogin.setOnClickListener{
                goToClubs()
            }

            btnRegister.setOnClickListener {
                goToRegister()
            }
        }

    }

    private fun goToRegister() {
        startActivity<RegisterActivity>()
    }

    private fun login(){
        with(binding){
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
        }
    }

    private fun goToClubs(){
        startActivity<IndexPlayerActivity>()
    }


}