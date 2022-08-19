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

        val job = lifecycleScope.launch(Dispatchers.IO){
            repeatLogs()
        }
        binding.btnStop.setOnClickListener { job.cancel() }
    }

    suspend fun repeatLogs() {
        while (true){
            Log.d(TAG, "repeatLogs: Still working..")
            delay(1000)
        }
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}