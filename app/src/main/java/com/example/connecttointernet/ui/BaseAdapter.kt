package com.example.connecttointernet.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


interface IBaseInterActionListener

abstract class BaseAdapter<T>(
    private var items: List<T>,
    private val listener: IBaseInterActionListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    fun setItems(newItems: List<T>) {
        items = newItems
    }

    fun getItems() = items

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItems = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(BR.item, currentItems)
                holder.binding.setVariable(BR.listener, listener)
            }
        }
    }

    abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false,
            )
        )
    }

    override fun getItemCount() = items.size

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}