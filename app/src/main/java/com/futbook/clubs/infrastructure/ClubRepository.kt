package com.futbook.clubs.infrastructure

import com.futbook.clubs.domain.Club

class ClubRepository {

    fun getListClubsByUser(id: Int):List<Club>{
        return listOf(
            Club(1, "Huracan", "hola@holis.com", 1235623, "calle orrius 11", "España", 1),
            Club(1, "GolaGol", "feo@holis.com", 789654, "calle menta 23", "Francia", 1),
            Club(1, "Santos", "messi@gmail.com", 88559966, "calle cedres 88", "España", 2)
        )
    }

}