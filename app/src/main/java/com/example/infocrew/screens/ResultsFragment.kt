package com.example.infocrew.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {
    private lateinit var binding: FragmentResultsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

}