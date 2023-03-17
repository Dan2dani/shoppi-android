package com.shoppi.app.ui.categoryDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.data.model.Product
import com.shoppi.app.databinding.ItemCategoryPromotionBinding

class CategoryPromotionAdapter :
    ListAdapter<Product, CategoryPromotionAdapter.categoryPromotionViewHolder>(
        categoryPromotionDiffCallback()
    ) {

    class categoryPromotionViewHolder(
        private val binding: ItemCategoryPromotionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryPromotionViewHolder {
        val binding =
            ItemCategoryPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return categoryPromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: categoryPromotionViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class categoryPromotionDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}