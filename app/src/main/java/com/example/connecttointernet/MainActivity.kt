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
            val deferred1 = async { request1() }
            val deferred2 = async { request2() }

            Log.d(TAG, "onCreate: ${deferred1.await()}")//request1
            Log.d(TAG, "onCreate: ${deferred2.await()}")//request2
        }
    }

    suspend fun request1(): String {
        delay(1000)
        return "request1"
    }
    suspend fun request2(): String {
        delay(3000)
        return "request2: "
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}