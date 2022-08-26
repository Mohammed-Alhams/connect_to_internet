package com.example.connecttointernet.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connecttointernet.R
import com.example.connecttointernet.databinding.ActivityMainBinding
import com.example.connecttointernet.model.State
import com.example.connecttointernet.ui.recyclerView.MoviesAdapter
import com.example.connecttointernet.viewModels.MoviesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = viewModel
        }

        val adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.moviesRecyclerView.adapter = adapter

        viewModel.movieLiveData.observe(this){ response ->
            if (response is State.Success)
                response.data?.movies?.let {
                    adapter.setItems(it)
                }
        }

    }


}