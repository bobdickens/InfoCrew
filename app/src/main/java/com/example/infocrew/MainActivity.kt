package com.example.infocrew

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.infocrew.presentation.adapters.VpAdapter
import com.example.infocrew.databinding.ActivityMainBinding
import com.example.infocrew.presentation.screens.FixturesFragment
import com.example.infocrew.presentation.screens.HomeFragment
import com.example.infocrew.presentation.screens.LeagueFragment
import com.example.infocrew.presentation.screens.PlayersFragment
import com.example.infocrew.presentation.screens.ResultsFragment
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val fragList = listOf(HomeFragment.newInstance(),
        FixturesFragment.newInstance(),
        ResultsFragment.newInstance(),
        LeagueFragment.newInstance(),
        PlayersFragment.newInstance())
    private val fragListTitles = listOf(
        "Home",
        "Fixtures",
        "Results",
        "League",
        "Players")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tabFunc()
        requestCrew("Barselona", applicationContext)


    }

    private fun tabFunc() {
        val vpAdapter = VpAdapter(this, fragList)
        binding.placeHolder.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.placeHolder){
                tab, pos -> tab.text = fragListTitles[pos]
        }.attach()}


    private fun requestCrew(crew: String, context: Context){
        val url = "http://167.235.200.159/4/json/crew.json"
        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(
            Request.Method.GET, url, {
                result -> Log.d("Volley", "Great! $result")
            },
            {
                error -> Log.d("Volley", "Error request $error")
            }
        )
        queue.add(request)

    }
}