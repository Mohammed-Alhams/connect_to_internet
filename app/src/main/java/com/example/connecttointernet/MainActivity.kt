package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.connecttointernet.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playWithCoroutines()
        binding.btnStop.setOnClickListener {
            job2.cancel()
        }
    }

    lateinit var job1: Job
    lateinit var job2: Job
    lateinit var job3: Job
    lateinit var job4: Job
    lateinit var job5: Job

    private fun playWithCoroutines() {
        val coroutinesExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d(TAG, "playWithCoroutines: ${throwable.message.toString()}")
        }
        job1 = lifecycleScope.launch(coroutinesExceptionHandler) {
            delay(2000)
            Log.d(TAG, "playWithCoroutines: job1")
            job2 = launch {
                delay(2000)
                Log.d(TAG, "playWithCoroutines: job2")
                job4 = launch {
                    delay(2000)
                    Log.d(TAG, "playWithCoroutines: job4")
                }
                job5 = launch {
                    delay(2000)
                    Log.d(TAG, "playWithCoroutines: job5")
                }
            }
            job3 = launch {
                delay(2000)
                val error = 5/0
                Log.d(TAG, "playWithCoroutines: job3")
            }
        }
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}