package com.example.infocrew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infocrew.data.json.GlobalCrew
import com.example.infocrew.data.json.ItemsViewModel
import com.example.infocrew.data.json.league.League
import com.example.infocrew.presentation.adapters.VpAdapter
import com.example.infocrew.databinding.ActivityMainBinding
import com.example.infocrew.presentation.adapters.DrawerAdapter
import com.example.infocrew.presentation.domain.MainViewModel
import com.example.infocrew.presentation.domain.retrofit2.ApiInterface
import com.example.infocrew.presentation.screens.FixturesFragment
import com.example.infocrew.presentation.screens.HomeFragment
import com.example.infocrew.presentation.screens.LeagueFragment
import com.example.infocrew.presentation.screens.PlayersFragment
import com.example.infocrew.presentation.screens.ResultsFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    private lateinit var adapter: DrawerAdapter

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
        responseCrew()
        responseLeague()
        bind()
        burgerListener()
        bindOfDrawer()



//
//        val data = ArrayList<ItemsViewModel>()
//        for (i in 1..20) {
//            data.add(ItemsViewModel("Item " + i))
//        }





    }

    private fun burgerListener(){
        binding.imBurgerButton.setOnClickListener {
          binding.drawer.openDrawer(GravityCompat.START)
        }
    }

    private fun responseLeague(){
        val apiInterface = ApiInterface.create().getLeague()
        apiInterface.enqueue( object : Callback<League> {
            override fun onResponse(call: Call<League>, response: Response<League>) {
                if(response.body() != null)
                    model.liveDataLeague.value = response.body()
                Log.d("Retrofit League", response.body().toString())
            }
            override fun onFailure(call: Call<League>, t: Throwable) {

            }
        })

    }
    private fun responseCrew(){
        val apiInterface = ApiInterface.create().getCrew()
        apiInterface.enqueue( object : Callback<GlobalCrew> {
            override fun onResponse(call: Call<GlobalCrew>, response: Response<GlobalCrew>) {
                if(response.body() != null)
                    model.liveDataList.value = response.body()
                    Log.d("Retrofit", "${response.body()}")
            }
            override fun onFailure(call: Call<GlobalCrew>, t: Throwable) {
            }
        })
    }

    private fun tabFunc() {
        val vpAdapter = VpAdapter(this, fragList)
        binding.placeHolder.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.placeHolder){
                tab, pos -> tab.text = fragListTitles[pos]
        }.attach()}

    private fun bind()= with(binding){
       model.liveDataList.observe(this@MainActivity){
           globalName.text = it[0].global_crew.name
           Picasso.get().load(it[0].global_crew.logo).into(globalLogo)
       }
    }

    private fun bindOfDrawer() {
        val list = arrayListOf<ItemsViewModel>()
        model.liveDataList.observe(this@MainActivity){

            val test = it
            for (index in test.indices) {
                //list += test[index].global_crew.name
                list.add(ItemsViewModel(test[index].global_crew.name, test[index].global_crew.logo))
            }
            Log.d("Test List", list.toString())
            binding.rcDrawer.layoutManager = LinearLayoutManager(this)
            adapter = DrawerAdapter(list)
            binding.rcDrawer.adapter = adapter


        }
    }




}