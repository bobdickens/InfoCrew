package com.example.infocrew.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentFixturesBinding

class FixturesFragment : Fragment() {
private lateinit var binding: FragmentFixturesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }


}