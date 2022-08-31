package com.example.connecttointernet.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.connecttointernet.ui.BaseAdapter

@BindingAdapter("app:adapterItems")
fun <T> setAdapterItems(view: RecyclerView, items: List<T>?) {
    val adapter: BaseAdapter<T>? = (view.adapter as BaseAdapter<T>)
    if (items != null)
        adapter?.setItems(items)
    else
        adapter?.setItems(emptyList())
}

//@BindingAdapter("app:items")
//fun <T> setAdapterItems(view: RecyclerView, items: List<T>?) {
//    val adapter : BaseAdapter<T>? = (view.adapter as BaseAdapter<T>)
//    if (items != null)
//        adapter?.setItems(items)
//    else
//        adapter?.setItems(emptyList())
//}