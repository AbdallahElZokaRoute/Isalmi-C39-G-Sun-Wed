package com.route.islami_c39_gsun_wed.islamiApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami_c39_gsun_wed.R
import com.route.islami_c39_gsun_wed.databinding.ItemSuraNameBinding
import com.route.islami_c39_gsun_wed.islamiApp.model.SuraNameIndex

class SuraNameAdapter(
    val suraItems: List<SuraNameIndex>?
) : Adapter<SuraNameAdapter.SuraNameViewHolder>() {
    var onSuraItemClickListener: OnSuraItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNameViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemSuraNameBinding.inflate(inflater, parent, false)
        return SuraNameViewHolder(binding)
    }
    // Clone -> Copy from remote repository into your device
    // Fork -> Copy from remote repository into your github account
    //


    override fun getItemCount(): Int {
        return suraItems?.size ?: 0
    }

    override fun onBindViewHolder(holder: SuraNameViewHolder, position: Int) {
        val item = suraItems?.get(position) ?: return
        holder.suraNameBinding.root.setOnClickListener {
            onSuraItemClickListener?.onSuraItemClick(item.name, item.index)
        }
        holder.bind(item)
    }

    class SuraNameViewHolder(val suraNameBinding: ItemSuraNameBinding) :
        ViewHolder(suraNameBinding.root) {
        fun bind(item: SuraNameIndex) {
            suraNameBinding.suraIndex.text = "${item.index}"
            suraNameBinding.suraName.text = item.name
        }
    }

    interface OnSuraItemClickListener {
        fun onSuraItemClick(suraName: String, index: Int)
    }

}
