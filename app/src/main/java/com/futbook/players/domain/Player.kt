package com.futbook.players.domain

data class Player(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val type: String = "",
    val phone: String = "",
    val birthday: String = "",
    val country: String = "",
    val position: String = "",
    val address: String = "",
    val weight: Double = 0.0,
    val height: Double = 0.0,
    val shoe_size: Double = 0.0,
    val t_shirt_size: String = "",
    val short_size: String = "",
    val skillful_foot: String = "",
    val injury: Boolean = false
)
