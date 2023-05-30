package com.example.infocrew.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentPlayersBinding

class PlayersFragment : Fragment() {
private lateinit var binding: FragmentPlayersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

}