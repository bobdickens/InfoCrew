package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.ItemsViewModel
import com.squareup.picasso.Picasso

//class DrawerAdapter :  ListAdapter<String, DrawerAdapter.Holder>(Comparator()){
//    class Holder(view: View) : RecyclerView.ViewHolder(view){
//        val binding = DrawerItemBinding.bind(view)
//
//        fun bind (item: String) = with(binding){
//            tvNameDrawer.text = item
//        }
//    }
//
//    class Comparator : DiffUtil.ItemCallback<String>(){
//        override fun areItemsTheSame(oldItem:String, newItem: String): Boolean {
//            return  oldItem == newItem
//
//        }
//
//        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.drawer_item, parent, false)
//        return Holder(view)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.bind(getItem(position))
//
//    }
//}

class DrawerAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<DrawerAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.drawer_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.textView.text = ItemsViewModel.name
        Picasso.get().load(ItemsViewModel.logo).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_logo)
        val textView: TextView = itemView.findViewById(R.id.tv_name_drawer)
    }
}