package com.futbook.clubs.infrastructure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.futbook.clubs.application.ClubsByUser
import com.futbook.clubs.domain.Club

class ClubsViewModel: ViewModel() {

    private val listClubs = MutableLiveData<List<Club>>()

    private val clubsByUser = ClubsByUser()

    init {
        getListClubs()
    }

    private fun setList (clubs: List<Club>) { listClubs.value = clubs }

    // se puede user coruotinas para informacion sea asincrona
    private fun getListClubs(){
        setList(clubsByUser.getClubs(1))
    }

    fun getListClubsLiveData(): LiveData<List<Club>>{
        return listClubs
    }

}