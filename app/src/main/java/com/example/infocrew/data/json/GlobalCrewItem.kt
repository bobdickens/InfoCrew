package com.example.infocrew.data.json

data class GlobalCrewItem(
    val championship_group: List<ChampionshipGroup>,
    val global_crew: GlobalCrewX,
    val players: List<PlayerX>,
    val results: List<Result>,
    val premiership: List<Premiership>,
    val relegation_group: List<RelegationGroup>,
    val fixtures: List<Fixture>
)