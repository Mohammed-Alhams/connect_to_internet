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

        var req2: String? = null
        var req1: String? = null

        val job = lifecycleScope.launch {
            val job1 = launch { req1 = request1() }
            val job2 = launch { req2 = request2() }

            job2.join()
//            job1.join()

            Log.d(TAG, "onCreate: $req1")//null
            Log.d(TAG, "onCreate: $req2")//request2
        }
    }

    suspend fun request1(): String {
        delay(3000)
        return "request1"
    }
    suspend fun request2(): String {
        delay(1000)
        return "request2: "
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}