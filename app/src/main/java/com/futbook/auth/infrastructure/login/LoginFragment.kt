package com.futbook.auth.infrastructure.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.futbook.api.domain.Resource
import com.futbook.auth.domain.AuthApi
import com.futbook.auth.infrastructure.AuthRepository
import com.futbook.auth.infrastructure.AuthViewModel
import com.futbook.databinding.FragmentLoginBinding
import com.futbook.players.infrastructure.IndexPlayerActivity
import com.futbook.base.BaseFragment
import com.futbook.util.enable
import com.futbook.util.startNewActivity
import com.futbook.util.visible

class  LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.progressbar.visible(false)
        binding.btnLogin.enable(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {

            binding.progressbar.visible(false)


            when (it) {
                is Resource.Success -> {
                    viewModel.saveAuthToken(it.value.token)
                    requireActivity().startNewActivity(IndexPlayerActivity::class.java)
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }

                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login failure", Toast.LENGTH_SHORT).show()

                }
            }
        })

        with(binding){

            etPassword.addTextChangedListener {
                val email = etEmail.text.toString().trim()
                btnLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
            }

            btnLogin.setOnClickListener {
                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString().trim()
                //@todo add input validations
                progressbar.visible(true)
                viewModel.login(email, password)
            }
        }


    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences)

}