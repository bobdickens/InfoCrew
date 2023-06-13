package com.example.infocrew.data.json

import androidx.annotation.Keep

@Keep
data class GlobalCrewItem(
    val global_crew: GlobalCrewX,
    val players: List<PlayerX>,
    val results: List<Result>,
    val fixtures: List<Fixture>
)