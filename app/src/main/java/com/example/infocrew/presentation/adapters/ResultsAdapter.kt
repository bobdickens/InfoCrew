package com.example.infocrew.presentation.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.PlayerX
import com.example.infocrew.data.json.Result
import com.example.infocrew.databinding.PlayersItemBinding
import com.example.infocrew.databinding.ResultItemBinding
import com.squareup.picasso.Picasso
@Keep
class ResultsAdapter:  ListAdapter<Result, ResultsAdapter.Holder>(Comparator()){
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ResultItemBinding.bind(view)

        fun bind (item: Result) = with(binding){
            tvNameCrew.text = item.name
            tvLegaue.text = item.league
            tvDate.text = item.date
            tvCurrent1.text = item.current_1
            tvCurrent2.text = item.current_2
            if(item.win == "false") { tvCurrent1.setTextColor(Color.parseColor("#FF0000"))
                tvCurrent2.setTextColor(Color.parseColor("#FF0000"))
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return  oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))

    }
}