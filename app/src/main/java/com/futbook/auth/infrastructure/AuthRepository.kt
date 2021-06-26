package com.futbook.auth.infrastructure

import com.futbook.api.domain.ApiService
import com.futbook.auth.application.Token
import com.futbook.auth.domain.AuthApi
import com.futbook.users.domain.UserPreferences
import com.futbook.base.BaseRepository

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
): BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.postLogin(email, password)
    }

    suspend fun saveAuthToken(token: Token) {
        preferences.saveAccessTokens(token.access_token, token.refresh_token)
    }
}