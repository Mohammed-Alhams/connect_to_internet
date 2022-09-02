package com.example.connecttointernet.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.connecttointernet.data.remote.State
import com.example.connecttointernet.ui.recyclerView.BaseAdapter


@BindingAdapter("app:showWhenSuccess")
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    if (state is State.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("app:showWhenLoading")
fun <T> showWhenLoading(view: View, state: State<T>?) {
    if (state is State.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("app:showWhenFailed")
fun <T> showWhenFailed(view: View, state: State<T>?) {
    if (state is State.Failed)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).centerCrop().into(view)
}

@BindingAdapter("app:items")
fun <T> setAdapterItems(view: RecyclerView, items: List<T>?) {
    val adapter : BaseAdapter<T>? = (view.adapter as BaseAdapter<T>)
    if (items != null)
        adapter?.setItems(items)
    else
        adapter?.setItems(emptyList())
}