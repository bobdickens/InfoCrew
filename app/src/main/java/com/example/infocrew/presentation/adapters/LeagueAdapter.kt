//package com.example.infocrew.presentation.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.infocrew.R
//import com.example.infocrew.data.json.PlayerX
//import com.example.infocrew.databinding.PlayersItemBinding
//import com.squareup.picasso.Picasso
//
//class PremiershipAdapter: ListAdapter<PlayerX, PlayersAdapter.Holder>(Comparator()){
//    class Holder(view: View) : RecyclerView.ViewHolder(view){
//        val binding = PlayersItemBinding.bind(view)
//
//        fun bind (item: PlayerX) = with(binding){
//            namePlayers.text = item.name
//            playerRole.text = item.role
//            playerArea.text = item.nation
//            Picasso.get().load(item.face).into(imageFace)
//        }
//    }
//
//    class Comparator : DiffUtil.ItemCallback<PlayerX>(){
//        override fun areItemsTheSame(oldItem: PlayerX, newItem: PlayerX): Boolean {
//            return  oldItem == newItem
//
//        }
//
//        override fun areContentsTheSame(oldItem: PlayerX, newItem: PlayerX): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.players_item, parent, false)
//        return Holder(view)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.bind(getItem(position))
//
//    }
//}
//class LeagueAdapter: ListAdapter<PlayerX, PlayersAdapter.Holder>(Comparator()){
//    class Holder(view: View) : RecyclerView.ViewHolder(view){
//        val binding = PlayersItemBinding.bind(view)
//
//        fun bind (item: PlayerX) = with(binding){
//            namePlayers.text = item.name
//            playerRole.text = item.role
//            playerArea.text = item.nation
//            Picasso.get().load(item.face).into(imageFace)
//        }
//    }
//
//    class Comparator : DiffUtil.ItemCallback<PlayerX>(){
//        override fun areItemsTheSame(oldItem: PlayerX, newItem: PlayerX): Boolean {
//            return  oldItem == newItem
//
//        }
//
//        override fun areContentsTheSame(oldItem: PlayerX, newItem: PlayerX): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.players_item, parent, false)
//        return Holder(view)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.bind(getItem(position))
//
//    }
//}
//class LeagueAdapter: ListAdapter<PlayerX, PlayersAdapter.Holder>(Comparator()){
//    class Holder(view: View) : RecyclerView.ViewHolder(view){
//        val binding = PlayersItemBinding.bind(view)
//
//        fun bind (item: PlayerX) = with(binding){
//            namePlayers.text = item.name
//            playerRole.text = item.role
//            playerArea.text = item.nation
//            Picasso.get().load(item.face).into(imageFace)
//        }
//    }
//
//    class Comparator : DiffUtil.ItemCallback<PlayerX>(){
//        override fun areItemsTheSame(oldItem: PlayerX, newItem: PlayerX): Boolean {
//            return  oldItem == newItem
//
//        }
//
//        override fun areContentsTheSame(oldItem: PlayerX, newItem: PlayerX): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.players_item, parent, false)
//        return Holder(view)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.bind(getItem(position))
//
//    }
//}