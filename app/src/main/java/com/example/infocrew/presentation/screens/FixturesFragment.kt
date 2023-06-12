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
import com.example.infocrew.data.json.Fixture
import com.example.infocrew.databinding.FixturesItemBinding
import com.example.infocrew.databinding.FragmentFixturesBinding
import com.example.infocrew.presentation.adapters.FixturesAdapter
import com.example.infocrew.presentation.adapters.PlayersAdapter
import com.example.infocrew.presentation.domain.MainViewModel
import kotlin.math.absoluteValue

class FixturesFragment : Fragment() {
    private lateinit var binding: FragmentFixturesBinding
    private val model: MainViewModel by activityViewModels()
    private lateinit var adapter: FixturesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding) {
        model.liveDataList.observe(viewLifecycleOwner){
            val list = it[model.index.value!!.absoluteValue].fixtures

            rv.layoutManager = LinearLayoutManager(activity)
            adapter = FixturesAdapter()
            rv.adapter = adapter
            adapter.submitList(list)
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FixturesFragment()
    }


}