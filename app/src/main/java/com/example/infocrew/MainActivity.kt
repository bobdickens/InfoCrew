package com.example.infocrew

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.infocrew.data.json.Crew
import com.example.infocrew.data.json.GlobalCrew
import com.example.infocrew.presentation.adapters.VpAdapter
import com.example.infocrew.databinding.ActivityMainBinding
import com.example.infocrew.presentation.domain.MainViewModel
import com.example.infocrew.presentation.domain.retrofit2.ApiInterface
import com.example.infocrew.presentation.screens.FixturesFragment
import com.example.infocrew.presentation.screens.HomeFragment
import com.example.infocrew.presentation.screens.LeagueFragment
import com.example.infocrew.presentation.screens.PlayersFragment
import com.example.infocrew.presentation.screens.ResultsFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()

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
//        requestCrew( applicationContext)
        responseCrew()
        bind()



    }

    private fun responseCrew(){

        val apiInterface = ApiInterface.create().getCrew()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<GlobalCrew> {
            override fun onResponse(call: Call<GlobalCrew>, response: Response<GlobalCrew>) {

                if(response.body() != null)
                    model.liveDataList.value = response.body()
                //recyclerAdapter.setMovieListItems(response.body()!!)
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


//    private fun requestCrew(context: Context){
//        val url = "http://167.235.200.159/4/json/crew.json"
//        val queue = Volley.newRequestQueue(context)
//        val request = StringRequest(
//            Request.Method.GET, url, {
//                result -> parseCrew(result)
//            },
//            {
//                error -> Log.d("Volley", "Error request $error")
//            }
//        )
//        queue.add(request)
//
//    }

//    private fun parseCrew (result: String) {
//        val mainObject = JSONObject(result)
//        val item = Crew(
//            mainObject.getJSONObject("global_crew").getString("name"),
//            mainObject.getJSONObject("global_crew").getString("logo"),
//            mainObject.getJSONObject("global_crew").getString("full_name"),
//            mainObject.getJSONObject("global_crew").getString("nickname"),
//            mainObject.getJSONObject("global_crew").getString("founded"),
//            mainObject.getJSONObject("global_crew").getString("website"),
//            mainObject.getJSONObject("global_crew").getString("next_match_name"),
//            mainObject.getJSONObject("global_crew").getString("league"),
//            mainObject.getJSONObject("global_crew").getString("next_match_date"),
//            mainObject.getJSONObject("global_crew").getString("venue_name"),
//            mainObject.getJSONObject("global_crew").getString("venue_capacity"),
//            mainObject.getJSONObject("global_crew").getString("staff_manager"),
//            mainObject.getJSONObject("global_crew").getString("corporate_owner"),
//            mainObject.getJSONObject("global_crew").getString("corporate_chairman"),
//
//        )
//        Log.d("Volley", "Great! ${item.name}")
//    }


}