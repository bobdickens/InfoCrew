package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.Fixture
import com.example.infocrew.databinding.FixturesItemBinding
import com.squareup.picasso.Picasso

class FixturesAdapter: ListAdapter<Fixture, FixturesAdapter.Holder>(Comparator()){
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = FixturesItemBinding.bind(view)

        fun bind (item: Fixture) = with(binding){
            tvNameCrew.text = item.name_crew
            tvDate.text = item.date
            tvLegaue.text = item.league
            Picasso.get().load(item.logo).into(imageLogo)
        }
    }

    class Comparator : DiffUtil.ItemCallback<Fixture>(){
        override fun areItemsTheSame(oldItem: Fixture, newItem: Fixture): Boolean {
            return  oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: Fixture, newItem: Fixture): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fixtures_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))

    }
}