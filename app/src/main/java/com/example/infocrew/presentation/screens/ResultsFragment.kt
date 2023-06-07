package com.example.infocrew.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infocrew.R
import com.example.infocrew.databinding.FragmentResultsBinding
import com.example.infocrew.presentation.adapters.PlayersAdapter
import com.example.infocrew.presentation.adapters.ResultsAdapter
import com.example.infocrew.presentation.domain.MainViewModel

class ResultsFragment : Fragment() {
    private lateinit var binding: FragmentResultsBinding
    private val model: MainViewModel by activityViewModels()
    private lateinit var adapter: ResultsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding) {
        model.liveDataList.observe(viewLifecycleOwner){
            val list = it[0].results
            Log.d("Recycler Test", it[0].results.toString())

            rv.layoutManager = LinearLayoutManager(activity)
            adapter = ResultsAdapter()
            rv.adapter = adapter
            adapter.submitList(list)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultsFragment()
    }

}