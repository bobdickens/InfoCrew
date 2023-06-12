package com.example.infocrew

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.infocrew.data.json.GlobalCrew
import com.example.infocrew.data.json.league.League
import com.example.infocrew.presentation.adapters.VpAdapter
import com.example.infocrew.databinding.ActivityMainBinding
import com.example.infocrew.presentation.domain.MainViewModel
import com.example.infocrew.presentation.domain.retrofit2.ApiInterface
import com.example.infocrew.presentation.screens.FixturesFragment
import com.example.infocrew.presentation.screens.HomeFragment
import com.example.infocrew.presentation.screens.LeagueFragment
import com.example.infocrew.presentation.screens.PlayersFragment
import com.example.infocrew.presentation.screens.ResultsFragment
import com.example.infocrew.presentation.screens.StartFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.absoluteValue

const val APP_PREF = "APP_PREF"
const val PREF_KEY = "PREF_KEY"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    //private lateinit var adapter: DrawerAdapter
   // private lateinit var alternativeDrawerAdapter: AlternativeDrawerAdapter


    private lateinit var pref: SharedPreferences

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
        pref = getSharedPreferences(APP_PREF, MODE_PRIVATE)

        model.index.observe(this@MainActivity){
            pref.edit().putInt(PREF_KEY, it).apply()
        }

//        model.currentIndex.observe(this@MainActivity){
//                pref.edit().putInt(PREF_KEY, it).apply()
//            Log.d("Absolute2", it.toString())
//
//        }
        //pref.edit().putInt(PREF_KEY, 0).apply()



        tabFunc()
        responseCrew()
        responseLeague()
        bind()
        burgerListener()

        val index = pref.getInt(PREF_KEY, 0)
        model.index.value = index

        binding.button.setOnClickListener{
            finish()
            startActivity(intent)
            overridePendingTransition(0, 1)
            Toast.makeText(this, "Restarting ${pref.getInt(PREF_KEY, 0)}", Toast.LENGTH_LONG).show()
        }

        //navController = Navigation.findNavController(this, R.id.drawer)
//
//        val data = ArrayList<ItemsViewModel>()
//        for (i in 1..20) {
//            data.add(ItemsViewModel("Item " + i))
//        }
    }

    private fun burgerListener(){
        binding.imBurgerButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.drawer, StartFragment.newInstance()).addToBackStack(null).commit()
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
                if (response.body() != null)
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
//           val index = model.index.value!!.absoluteValue
           val index = model.index.value?.absoluteValue
           Log.d("Absolut", model.index.value!!.absoluteValue.toString())
           globalName.text = it[index!!].global_crew.name
           Picasso.get().load(it[index].global_crew.logo).into(globalLogo)
       }
    }
}