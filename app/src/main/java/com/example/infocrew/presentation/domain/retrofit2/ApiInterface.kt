package com.example.infocrew.presentation.domain.retrofit2

import com.example.infocrew.data.json.GlobalCrew
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("crew.json")
    fun getCrew() : Call<GlobalCrew>

    companion object {

        var BASE_URL = "http://167.235.200.159/4/json/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}