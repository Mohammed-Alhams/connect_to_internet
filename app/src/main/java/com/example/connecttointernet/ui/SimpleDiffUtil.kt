package com.example.connecttointernet.ui

import androidx.recyclerview.widget.DiffUtil

open class SimpleDiffUtil<T>(
    private val oldItems: List<T>,
    private val newItems: List<T>,
    private val checkIfSame: (oldItem: T, newItem: T) -> Boolean
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        checkIfSame(oldItems[oldItemPosition], newItems[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}