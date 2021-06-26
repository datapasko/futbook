package com.futbook.auth.infrastructure.register

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.futbook.R
import com.futbook.api.domain.ApiService
import com.futbook.api.application.SimpleResponse
import com.futbook.auth.application.LoginResponse
import com.futbook.databinding.ActivityRegisterBinding
import com.futbook.util.PreferenceHelper
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    private val apiService by lazy {
        ApiService.create()
    }

    private val preferences by lazy {
        PreferenceHelper.defaultPrefs(this)
    }

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Registrarse"

        with(binding){
            btnRegister.setOnClickListener {
                validateLogin()
            }
        }
    }

    fun test() {
        val call = apiService.getTest()
        call.enqueue(object: Callback<SimpleResponse> {
            override fun onFailure(call: Call<SimpleResponse>, t: Throwable) {
                toast("Conexión fallida, por favor revise su conexión a internet")
            }

            override fun onResponse(call: Call<SimpleResponse>, response: Response<SimpleResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()

                    Log.d("messil", loginResponse.toString())

                    if (loginResponse == null) {
                        toast(getString(R.string.error_login_response))
                        return
                    }

                    /*if (loginResponse) {
                        toast(loginResponse.toString())
                        //createSessionPreference(loginResponse)
                        //goToRegister()
                        // } else {
                        toast(getString(R.string.toast_bad_credentials))
                    }*/

                } else {
                    toast(getString(R.string.error_login_response))
                }
            }
        })
    }

    private fun validateLogin() {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("name", name)
            .addFormDataPart("email", email)
            .addFormDataPart("password", password)
            .addFormDataPart("password_confirmation", confirmPassword)
            .build()




        val call = apiService.postRegister(requestBody)
        call.enqueue(object: Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                toast("Conexión fallida, por favor revise su conexión a internet")
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()

                    Log.d("messil", loginResponse.toString())

                    if (loginResponse == null) {
                        toast(getString(R.string.error_login_response))
                        return
                    }

                    /*if (loginResponse) {
                        toast(loginResponse.toString())
                        //createSessionPreference(loginResponse)
                        //goToRegister()
                        // } else {
                        toast(getString(R.string.toast_bad_credentials))
                    }*/

                } else {
                    toast(getString(R.string.error_login_response))
                }
            }
        })
    }

    private fun createSessionPreference(loginResponse: LoginResponse) {
        /*preferences["jwt"] =  loginResponse.jwt
        preferences["session_email"] =  loginResponse.user.email
        preferences["session_id"] =  loginResponse.user.id*/
    }

}
