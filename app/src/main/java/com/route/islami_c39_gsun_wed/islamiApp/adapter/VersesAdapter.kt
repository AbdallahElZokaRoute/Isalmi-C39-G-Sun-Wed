package com.route.islami_c39_gsun_wed.islamiApp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami_c39_gsun_wed.databinding.ItemVerseBinding

class VersesAdapter(var versesList: List<String>?) : Adapter<VersesAdapter.VersesViewHolder>() {

    var onHadethItemClickListener: OnHadethItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VersesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return versesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        val item = versesList?.get(position) ?: return
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            onHadethItemClickListener?.onHadethItemClick(position)
        }
    }

    fun updateData(versesList: List<String>) {
        this.versesList = versesList
        notifyDataSetChanged()// remove all items and reload your self
    }

    class VersesViewHolder(val binding: ItemVerseBinding) : ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.verseText.text = item
        }
    }

    interface OnHadethItemClickListener {
        fun onHadethItemClick(index: Int)
    }

}
