package com.example.connecttointernet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.connecttointernet.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val job = lifecycleScope.launch {
            launch { request1() }
            launch { request2() }
        }
    }

    suspend fun request1() {
        delay(3000)
        Log.d(TAG, "request1: ")
    }
    suspend fun request2() {
        delay(1000)
        Log.d(TAG, "request2: ")
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}