package com.example.connecttointernet.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connecttointernet.R
import com.example.connecttointernet.databinding.ActivityMainBinding
import com.example.connecttointernet.ui.recyclerView.MoviesAdapter
import com.example.connecttointernet.viewModels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MoviesViewModel>()

    @Inject
    @Named("second")
    lateinit var injectedField: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = MoviesAdapter(viewModel.movieLiveData.value ?: emptyList(), viewModel)
        binding.moviesRecyclerView.adapter = adapter

        Toast.makeText(this, injectedField, Toast.LENGTH_SHORT).show()
    }


}