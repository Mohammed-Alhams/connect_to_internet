package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.connecttointernet.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Completable
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
        val completable = Completable.create { emmiter ->
            binding.etText.doOnTextChanged { _, _, _, count ->
                if (count >= 5)
                    emmiter.onComplete()
            }
        }

        completable.subscribe(this::onSendingCompleted,this::onSendingFailed)
    }

    private fun onSendingCompleted(){
        Log.d(TAG, "onSendingCompleted: ")
    }

    private fun onSendingFailed(e: Throwable){
        Log.d(TAG, "onSendingFailed: ${e.message}")
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}