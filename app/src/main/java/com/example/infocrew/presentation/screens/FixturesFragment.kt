package com.example.infocrew.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentFixturesBinding
import com.example.infocrew.domain.MainViewModel

class FixturesFragment : Fragment() {
private lateinit var binding: FragmentFixturesBinding
private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FixturesFragment()
    }


}