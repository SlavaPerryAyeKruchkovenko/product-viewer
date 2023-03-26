package com.example.product_viewer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.product_viewer.databinding.ProductItemCollapsedBinding
import com.example.product_viewer.databinding.ProductItemExpandBinding

class ProductListAdapter(val listener: Listener) : ListAdapter<Product, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            0 -> {
                val binding = ProductItemCollapsedBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                ProductHolderCollapsed(binding)
            }
            else -> {
                val binding = ProductItemExpandBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                ProductHolderExpand(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).viewType) {
            0 -> 0
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as ProductHolderCollapsed).bind(getItem(position), listener)
            else -> (holder as ProductHolderExpand).bind(getItem(position), listener)

        }
    }

    class ProductHolderExpand(private val binding: ProductItemExpandBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product, listener: Listener) = with(binding) {
            itemView.setOnClickListener{
                listener.onClick(product)
            }
            productImage.setImageResource(product.imageId)
            cardTitle.text=product.titleText
            cardSubHeader.text=product.titleSubHeadText
            cardDescription.text = product.descriptionText
            productHeader.avatar.setImageResource(product.avatarId)
            productHeader.headerText.text = product.headerText
            productHeader.subHeaderText.text = product.subheadText
        }
    }

    class ProductHolderCollapsed(private val binding: ProductItemCollapsedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product, listener: Listener) = with(binding) {
            itemView.setOnClickListener{
                listener.onClick(product)
            }
            avatar.setImageResource(product.avatarId)
            header.text = product.headerText
            subHeader.text = product.subheadText
            headerBtn.setImageResource(product.image80dpId)
        }
    }


    class MyDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    interface Listener{
        fun onClick(product: Product)
    }
}
