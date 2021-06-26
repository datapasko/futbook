package com.futbook.categories.domain

data class Category(
    val id: Int = 0,
    val name: String = "",
    val coach: String = "",
    val stadium: String = "",
    val description: String = "",
    val club_id: Int = 0,
)
