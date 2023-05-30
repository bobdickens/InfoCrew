package com.example.infocrew.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentLeagueBinding

class LeagueFragment : Fragment() {
private lateinit var binding: FragmentLeagueBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        return binding.root
    }

}