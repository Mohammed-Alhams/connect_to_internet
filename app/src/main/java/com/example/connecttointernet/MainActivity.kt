package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.connecttointernet.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope/*coroutines scope*/.launch(Dispatchers.IO/*coroutines dispatcher*/)
        {//coroutines builder
            fakeRequest()
        }
        Log.d(TAG, "onCreate: after request")
    }

    suspend fun fakeRequest() {
        delay(3000)
        Log.d(TAG, "fakeRequest: result")
        Log.d(TAG, "fakeRequest: ${Thread.currentThread().name}")
        withContext(Dispatchers.Main) {
            binding.tvText.text = "fakeRequest"
            Log.d(TAG, "fakeRequest: ${Thread.currentThread().name}")//context switching
        }
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}