package com.example.infocrew.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infocrew.R
import com.example.infocrew.data.json.PlayerX
import com.example.infocrew.databinding.FragmentPlayersBinding
import com.example.infocrew.presentation.adapters.PlayersAdapter

class PlayersFragment : Fragment() {
    private lateinit var binding: FragmentPlayersBinding
    private lateinit var adapter: PlayersAdapter

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
        rv.layoutManager = LinearLayoutManager(activity)
        adapter = PlayersAdapter()
        rv.adapter = adapter
        val list = listOf(
            PlayerX("test", "Peter Ivanov", "Russia", "Bombardir")
        )
        adapter.submitList(list)

    }

    companion object {
        @JvmStatic
        fun newInstance() = PlayersFragment()
    }

}