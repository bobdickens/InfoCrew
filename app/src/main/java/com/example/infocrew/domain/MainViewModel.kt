package com.example.infocrew.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infocrew.data.json.GlobalCrewX

class MainViewModel: ViewModel() {
    val liveDataList = MutableLiveData<List<GlobalCrewX>>()

}