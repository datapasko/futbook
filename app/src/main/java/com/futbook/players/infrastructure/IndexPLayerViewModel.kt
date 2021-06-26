package com.futbook.players.infrastructure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.futbook.players.domain.Player

class IndexPLayerViewModel: ViewModel() {

    private val player = MutableLiveData<Player>()


}