package com.example.connecttointernet.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.connecttointernet.databinding.ActivityMainBinding
import com.example.connecttointernet.model.domain.User
import com.example.connecttointernet.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup(){
        viewModel.getUserInfo()
        binding.btnGenerate.setOnClickListener { viewModel.getWisdom() }

        viewModel.currentUser.observe(this
        ) { binding.tvName.text = it.userName }

        viewModel.wisdom.observe(this){
            binding.tvWisdomDate.text = it.publishDate
            binding.tvWisdomContent.text = it.content
        }
    }

}