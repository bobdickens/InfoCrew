package com.example.infocrew.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infocrew.data.json.ItemsViewModel
import com.example.infocrew.databinding.FragmentStartBinding
import com.example.infocrew.presentation.adapters.AlternativeDrawerAdapter
import com.example.infocrew.presentation.adapters.OnClickItem
import com.example.infocrew.presentation.domain.MainViewModel

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private lateinit var alternativeDrawerAdapter: AlternativeDrawerAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindOfDrawer()

        binding.btnClose.setOnClickListener {
            getActivity()?.onBackPressed()
        }


    }

    private fun bindOfDrawer() {
        val list = arrayListOf<ItemsViewModel>()
        model.liveDataList.observe(viewLifecycleOwner){

            val test = it
            for (index in test.indices) {
                list.add(ItemsViewModel(test[index].global_crew.name, test[index].global_crew.logo, index))
            }
            Log.d("Test List", list.toString())
            binding.rcDrawer.layoutManager = LinearLayoutManager(activity)
            alternativeDrawerAdapter = AlternativeDrawerAdapter(list, object : OnClickItem {
                override fun click(item: ItemsViewModel) {
                    Toast.makeText(activity, "Работает!", Toast.LENGTH_LONG).show()
                    Log.d("Alternative", "Working")
                }
            })
            binding.rcDrawer.adapter = alternativeDrawerAdapter


        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }

}