package com.example.infocrew.presentation.screens

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infocrew.APP_PREF
import com.example.infocrew.PREF_KEY
import com.example.infocrew.R
import com.example.infocrew.data.json.PlayerX
import com.example.infocrew.databinding.FragmentPlayersBinding
import com.example.infocrew.presentation.domain.MainViewModel
import com.example.infocrew.presentation.adapters.PlayersAdapter
import kotlin.math.absoluteValue

class PlayersFragment : Fragment() {
    private lateinit var binding: FragmentPlayersBinding
    private val model: MainViewModel by activityViewModels()
    private lateinit var adapter: PlayersAdapter
    private lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRcView()
    }

    private fun initRcView() = with(binding) {
        model.liveDataList.observe(viewLifecycleOwner){
           val list = it[model.index.value!!.absoluteValue].players

            rv.layoutManager = LinearLayoutManager(activity)
            adapter = PlayersAdapter()
            rv.adapter = adapter
            adapter.submitList(list)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PlayersFragment()
    }

}