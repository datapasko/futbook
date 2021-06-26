package com.futbook.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.futbook.auth.infrastructure.AuthRepository
import com.futbook.auth.infrastructure.AuthViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory (
    private val repository: BaseRepository
    ) : ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return when {
                modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
                else -> throw IllegalArgumentException("ViewModelClass not found")
            }
        }
    }