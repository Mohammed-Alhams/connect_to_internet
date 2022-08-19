package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.connecttointernet.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

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
        val observable = Observable.interval(1, TimeUnit.SECONDS).publish()
        observable.connect()

        observable
            .subscribe(
                {t -> Log.d(TAG, "first subscriber: $t")},
                {e -> },
                {}
            )

        Thread.sleep(4000)

        observable
            .subscribe(
                {t -> Log.d(TAG, "second subscriber: $t")},
                {e -> },
                {}
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