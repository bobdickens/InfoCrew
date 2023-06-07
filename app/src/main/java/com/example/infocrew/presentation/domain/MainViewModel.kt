package com.example.infocrew.presentation.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infocrew.data.json.Crew
import com.example.infocrew.data.json.GlobalCrew
import com.example.infocrew.data.json.league.League


class MainViewModel: ViewModel() {
    val liveDataList = MutableLiveData<GlobalCrew>()
    val liveDataLeague = MutableLiveData<League>()

}