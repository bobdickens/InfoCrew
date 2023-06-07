package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.league.ChampionshipGroup
import com.example.infocrew.data.json.league.League
import com.example.infocrew.databinding.LeagueItemBinding
import com.squareup.picasso.Picasso

class ChampionshipAdapter: ListAdapter<ChampionshipGroup, ChampionshipAdapter.Holder>(Comparator()){
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = LeagueItemBinding.bind(view)

        fun bind (item: ChampionshipGroup) = with(binding){
            tvName.text = item.name
            tvP.text = item.p
            tvW.text = item.w
            tvD.text = item.d
            tvL.text = item.l
            tvPlus.text = item.plus
            tvP2.text = item.p2
            Picasso.get().load(item.logo).into(ivLogo)
        }
    }

    class Comparator : DiffUtil.ItemCallback<ChampionshipGroup>(){
        override fun areItemsTheSame(oldItem: ChampionshipGroup, newItem: ChampionshipGroup): Boolean {
            return  oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: ChampionshipGroup, newItem: ChampionshipGroup): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.league_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))

    }
}
