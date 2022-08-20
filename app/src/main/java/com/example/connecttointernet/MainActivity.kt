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

        val mFlow = flow<Int> {
            for (i in 1..10){
                emit(i)
                delay(2000)
            }
        }
        
        lifecycleScope.launch {
            mFlow.buffer()//Buffers flow emissions via channel of a specified capacity and runs collector in a separate coroutine
                .collect{
                    delay(2000)
                    Log.d(TAG, "playWithFlow: $it")
                }
        }
    }

    companion object {
        private const val TAG = "co-alhams"
    }
}