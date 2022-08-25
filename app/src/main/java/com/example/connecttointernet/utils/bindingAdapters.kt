package com.example.connecttointernet.utils

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.connecttointernet.model.State

@BindingAdapter("app:showWhenSuccess")
fun <T> showWhenSuccess(view : View, state : State<T>?){
    if (state is State.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("app:showWhenLoading")
fun <T> showWhenLoading(view : View, state : State<T>?){
    if (state is State.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("app:showWhenFailed")
fun <T> showWhenFailed(view : View, state : State<T>?){
    if (state is State.Failed)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}