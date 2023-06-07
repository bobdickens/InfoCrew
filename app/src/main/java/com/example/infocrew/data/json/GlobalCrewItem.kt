package com.example.infocrew.data.json

data class GlobalCrewItem(
    val global_crew: GlobalCrewX,
    val players: List<PlayerX>,
    val results: List<Result>,
    val fixtures: List<Fixture>
)