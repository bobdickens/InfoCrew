package com.example.infocrew.data.json.league

import androidx.annotation.Keep

@Keep
data class League(
    val championship_group: List<ChampionshipGroup>,
    val premiership: List<Premiership>,
    val relegation_group: List<RelegationGroup>
)