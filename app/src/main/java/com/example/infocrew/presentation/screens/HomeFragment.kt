package com.example.infocrew.presentation.screens

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentHomeBinding
import com.example.infocrew.domain.MainViewModel

class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding
private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()


    }

    private fun bind()= with(binding){
        model.liveDataList.observe(viewLifecycleOwner){
            tvNameOverview.text = it[1].global_crew.name
            tvFullNameOverview.text = it[1].global_crew.full_name
            tvNicknameOverview.text = it[1].global_crew.nickname
            tvFoundedOverview.text = it[1].global_crew.founded
            tvWebsiteOverview.text = it[1].global_crew.website
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}