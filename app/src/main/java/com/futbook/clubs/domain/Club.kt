package com.futbook.clubs.domain

data class Club(
    val id: Int = 0,
    val name:String = "",
    val email:String = "",
    val phone:Int = 0,
    val address:String = "",
    val country:String = "",
    val user_id:Int = 0,
)
