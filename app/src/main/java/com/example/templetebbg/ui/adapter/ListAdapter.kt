package com.example.templetebbg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.templetebbg.databinding.ListItemBinding
import com.example.templetebbg.domain.Entity

class ListAdapter : RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {
    var onItemClick: ((Entity) -> Unit)? = null

    private val differCallback = object : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(differ.currentList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            tvId.text = item.id.toString()
            tvTitle.text = item.title
            tvBody.text = item.body
        }
    }

    override fun getItemCount(): Int =  differ.currentList.size
}