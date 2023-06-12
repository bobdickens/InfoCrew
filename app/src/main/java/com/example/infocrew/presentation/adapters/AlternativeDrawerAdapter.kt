package com.example.infocrew.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.infocrew.R
import com.example.infocrew.data.json.ItemsViewModel
import com.example.infocrew.databinding.DrawerItemBinding
import com.squareup.picasso.Picasso

interface OnClickItem {
    fun click(item: ItemsViewModel)
}

class AlternativeDrawerAdapter(private val mList: List<ItemsViewModel>, private val clickItem: OnClickItem): RecyclerView.Adapter<AlternativeDrawerAdapter.ViewHolder>(), View.OnClickListener {

    class ViewHolder(val binding: DrawerItemBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DrawerItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)
        binding.tvNameDrawer.setOnClickListener(this)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = mList[position]
        with(holder.binding){
            tvNameDrawer.text = items.name
            holder.itemView.tag = items
            tvNameDrawer.tag = items
            Picasso.get().load(items.logo).into(ivLogo)

        }
    }

    override fun onClick(v: View) {
        val item = v.tag as ItemsViewModel
        when (v.id) {
            R.id.tv_name_drawer -> {
                clickItem.click(item)
            }
            else -> clickItem.click(item)
        }
    }
}