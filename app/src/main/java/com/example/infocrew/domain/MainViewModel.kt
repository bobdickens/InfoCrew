package com.example.infocrew.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infocrew.data.json.Crew
import com.example.infocrew.data.json.GlobalCrew


class MainViewModel: ViewModel() {
    val liveDataList = MutableLiveData<GlobalCrew>()
    val liveDataCrew = MutableLiveData<List<Crew>>()

}