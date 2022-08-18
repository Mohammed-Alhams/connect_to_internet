package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.connecttointernet.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foo()
    }

    private fun foo() {
        val observable = Observable.just(1, 5, 7, 10, 12)

        observable.subscribe(
            { t -> Log.d(TAG, "foo: $t") },
            { e -> Log.d(TAG, "foo: ${e.message}") }
        )
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}