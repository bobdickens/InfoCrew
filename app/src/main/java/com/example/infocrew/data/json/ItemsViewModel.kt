package com.example.infocrew.data.json

import androidx.annotation.Keep

@Keep
data class ItemsViewModel (
    val name: String,
    val logo: String,
    val position: Int
        )