package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.connecttointernet.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playWithFlow()
    }

    private fun playWithFlow() {

        val mRange = 1..10

        val flow = mRange.asFlow()
            .onEach {
                delay(1000)
            }
            .flowOn(Dispatchers.Default)


        lifecycleScope.launch {
            flow.catch { Log.d(TAG, "playWithFlow: ${it.message}") }
                .onCompletion { Log.d(TAG, "playWithFlow: completed") }
                .collect { Log.d(TAG, "playWithFlow: $it") }
        }
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}