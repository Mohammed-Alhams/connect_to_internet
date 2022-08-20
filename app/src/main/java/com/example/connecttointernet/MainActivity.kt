package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.connecttointernet.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playWithFlow()
    }

    private fun playWithFlow() {
        val flow = flow<Int> {
            for (i in 1..12) {
                Log.d(TAG, "playWithFlow: ${Thread.currentThread().name}")
                emit(i)
                delay(1000)
            }
        }.flowOn(Dispatchers.Default)

        lifecycleScope.launch {
            flow.map { it * it }
                .filter { it % 2 == 0 }
                .collect { Log.d(TAG, "playWithFlow: $it") }
        }
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}