package com.example.infocrew.data.json

import android.support.annotation.Keep

@Keep
data class Result(
    val current_1: String,
    val current_2: String,
    val date: String,
    val league: String,
    val logo: String,
    val name: String,
    val win: String
)