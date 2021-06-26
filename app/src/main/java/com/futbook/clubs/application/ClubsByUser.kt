package com.futbook.clubs.application

import com.futbook.clubs.domain.Club
import com.futbook.clubs.infrastructure.ClubRepository

class ClubsByUser {

    private val repository =  ClubRepository ()

    fun getClubs(id: Int):List<Club>{
        return repository.getListClubsByUser(id)
    }
}