package com.example.infocrew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.infocrew.databinding.ActivityMainBinding
import com.example.infocrew.presentation.screens.FixturesFragment
import com.example.infocrew.presentation.screens.HomeFragment
import com.example.infocrew.presentation.screens.LeagueFragment
import com.example.infocrew.presentation.screens.PlayersFragment
import com.example.infocrew.presentation.screens.ResultsFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val fragList = listOf(HomeFragment.newInstance(),
        FixturesFragment.newInstance(),
        ResultsFragment.newInstance(),
        LeagueFragment.newInstance(),
        PlayersFragment.newInstance())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[tab?.position!!]).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}