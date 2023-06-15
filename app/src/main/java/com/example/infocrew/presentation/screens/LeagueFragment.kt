package com.example.infocrew.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infocrew.databinding.FragmentLeagueBinding
import com.example.infocrew.presentation.adapters.ChampionshipAdapter
import com.example.infocrew.presentation.adapters.PremiershipAdapter
import com.example.infocrew.presentation.adapters.RelegationAdapter
import com.example.infocrew.presentation.domain.MainViewModel
@Keep
class LeagueFragment : Fragment() {
    private lateinit var binding: FragmentLeagueBinding
    private lateinit var adapter: ChampionshipAdapter
    private val model: MainViewModel by activityViewModels()
    private lateinit var relegationAdapter : RelegationAdapter
    private lateinit var premiershipAdapter : PremiershipAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        initRcViewRelegation()
        initRcViewPremiership()
    }

    private fun initRcViewPremiership() = with(binding) {
        model.liveDataLeague.observe(viewLifecycleOwner){
            val list2 = it.premiership
            rv3.layoutManager = LinearLayoutManager(activity)
            premiershipAdapter = PremiershipAdapter()
            rv3.adapter = premiershipAdapter
            premiershipAdapter.submitList(list2)
        }
    }
    private fun initRcViewRelegation() = with(binding) {
        model.liveDataLeague.observe(viewLifecycleOwner){
            val list1 = it.relegation_group
            rv2.layoutManager = LinearLayoutManager(activity)
            relegationAdapter = RelegationAdapter()
            rv2.adapter = relegationAdapter
            relegationAdapter.submitList(list1)
        }
    }
    private fun initRcView() = with(binding) {
        model.liveDataLeague.observe(viewLifecycleOwner){
            val list = it.championship_group
            rv1.layoutManager = LinearLayoutManager(activity)
            adapter = ChampionshipAdapter()
            rv1.adapter = adapter
            adapter.submitList(list)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LeagueFragment()
    }

}