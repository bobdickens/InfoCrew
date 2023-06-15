package com.example.infocrew.presentation.domain

import android.content.SharedPreferences
import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infocrew.data.json.Crew
import com.example.infocrew.data.json.GlobalCrew
import com.example.infocrew.data.json.league.League

@Keep
class MainViewModel: ViewModel() {
    val liveDataList = MutableLiveData<GlobalCrew>()
    val liveDataLeague = MutableLiveData<League>()
    val index = MutableLiveData<Int>()

}