package com.example.infocrew.data.json

import androidx.annotation.Keep

@Keep
data class Fixture(
    val date: String,
    val league: String,
    val logo: String,
    val name_crew: String
)