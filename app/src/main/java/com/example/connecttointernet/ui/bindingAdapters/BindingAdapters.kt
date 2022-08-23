package com.example.connecttointernet.ui.bindingAdapters

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.connecttointernet.R

@BindingAdapter("ButtonColor")
fun changeColors(view: View, colors: Colors?){
    when(colors){
        Colors.RED -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.red))
        Colors.BLUE -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.green))
        Colors.GREEN -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.purple_200))
        null -> {}
    }
}

@BindingAdapter("showIfTrue")
fun showIfTrue(view: View, value: Boolean?){
    if (value == true) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}


enum class Colors {
    RED,
    BLUE,
    GREEN
}