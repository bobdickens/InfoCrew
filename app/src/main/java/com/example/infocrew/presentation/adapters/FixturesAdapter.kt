package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.Fixtures
import com.example.infocrew.data.json.PlayerX
import com.example.infocrew.databinding.FixturesItemBinding
import com.example.infocrew.databinding.PlayersItemBinding
import com.squareup.picasso.Picasso

class FixturesAdapter: ListAdapter<Fixtures, FixturesAdapter.Holder>(Comparator()){
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = FixturesItemBinding.bind(view)

        fun bind (item: Fixtures) = with(binding){
            tvNameCrew.text = item.name_crew
            tvDate.text = item.date
            tvLegaue.text = item.league
            Picasso.get().load(item.logo).into(imageLogo)
        }
    }

    class Comparator : DiffUtil.ItemCallback<Fixtures>(){
        override fun areItemsTheSame(oldItem: Fixtures, newItem: Fixtures): Boolean {
            return  oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: Fixtures, newItem: Fixtures): Boolean {
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