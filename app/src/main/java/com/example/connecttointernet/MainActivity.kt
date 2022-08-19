package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.connecttointernet.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        compositeDisposable = CompositeDisposable()
        setContentView(binding.root)

        foo()
    }

    private fun foo() {
        val maybe = Maybe.create<String> { emiter ->
            binding.etText.doOnTextChanged { text, _, _, count ->
                when(text.toString()) {
                    "yes" -> emiter.onSuccess("yesssssss")
                    "no" -> emiter.onComplete()
                }
            }
        }

        maybe.subscribe(
            { t -> Log.d(TAG, "foo: $t") },
            { e -> Log.d(TAG, "foo: ${e.message}") },
            { Log.d(TAG, "foo: completed") }
        )

    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}