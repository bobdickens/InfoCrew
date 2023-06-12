package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.ItemsViewModel
import com.example.infocrew.databinding.DrawerItemBinding
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


interface OnClick {
    fun click(item: ItemsViewModel)
}

class DrawerAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<DrawerAdapter.ViewHolder>(), View.OnClickListener {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        val binding = DrawerItemBinding.inflate(inflater, parent, false)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.drawer_item, parent, false)


        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.itemView.tag = item

    holder.bind(mList[position])



       // holder.imageView.

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val binding = DrawerItemBinding.bind(itemView)

        fun bind (item: ItemsViewModel) = with(binding){
            Picasso.get().load(item.logo).into(ivLogo)
            tvNameDrawer.text = item.name


        }

    }

    override fun onClick(v: View) {
        val item = v.tag as ItemsViewModel
    }


}