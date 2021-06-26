package com.futbook.auth.application

data class LoginResponse(
    val token: Token,
    val user: User
)