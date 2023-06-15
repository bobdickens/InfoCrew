package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.ItemsViewModel
import com.example.infocrew.databinding.DrawerItemBinding
import com.squareup.picasso.Picasso

@Keep
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