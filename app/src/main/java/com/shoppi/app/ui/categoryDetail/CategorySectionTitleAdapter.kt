package com.shoppi.app.ui.categoryDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.data.model.Title
import com.shoppi.app.databinding.ItemTitleBinding

class CategorySectionTitleAdapter :
    ListAdapter<Title, CategorySectionTitleAdapter.CategorySectionTitleViewHolder>(
        categoryTitleDiffCallback()
    ) {

    class CategorySectionTitleViewHolder(private val binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(title: Title) {
            binding.title = title
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategorySectionTitleViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategorySectionTitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategorySectionTitleViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class categoryTitleDiffCallback : DiffUtil.ItemCallback<Title>() {
    override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem == newItem
    }
}