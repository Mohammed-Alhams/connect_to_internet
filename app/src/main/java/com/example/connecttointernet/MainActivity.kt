package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.connecttointernet.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

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
//        val observable = Observable.fromArray(1,2,3,4,5,6,7,8,9,10,11,12,13)
//        val observable = Observable.fromIterable(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13))
//        val observable = Observable.fromIterable(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13))
//            .repeat(3)
//        val observable = Observable.range(10, 20)
//        val observable = Observable.interval(2,TimeUnit.SECONDS)
//        val observable = Observable.interval(2,TimeUnit.SECONDS).take(5)
//        val observable = Observable.interval(2,TimeUnit.SECONDS).take(5, TimeUnit.SECONDS)
//        val observable = Observable.range(1,10000).takeLast(5)
//        val observable = Observable.range(1,20).skip(10)
//        val observable = Observable.timer(5, TimeUnit.SECONDS)
//        val observable = Observable.fromIterable(listOf(1,2,3,4,4,5,7,8,8,10)).distinct()
//        val observable = Observable.fromIterable(listOf(1,2,3,4,4,5,7,8,8,10)).buffer(2)
//        val observable = Observable.fromIterable(listOf(1,2,3,4,4,5,7,8,8,10))
//            .map { mapOf(it to "$it's") }
////        *****************
//        val observableTwo = Observable.interval(2,TimeUnit.SECONDS)
//            .take(5)
//        val observable = Observable.interval(500, TimeUnit.MILLISECONDS)
//            .take(5)
//            .concatWith(observableTwo)
////        ****************
////        *****************
//        val observableTwo = Observable.interval(2,TimeUnit.SECONDS)
//            .take(100).map { it * 100 }
//        val observable = Observable.interval(500, TimeUnit.MILLISECONDS)
//            .take(100)
//            .mergeWith(observableTwo)
////        ****************
////        *****************
//        val observableTwo = Observable.interval(2,TimeUnit.SECONDS)
//            .take(100).map { it * 100 }
//        val observable = Observable.interval(500, TimeUnit.MILLISECONDS)
//            .take(100)
//            .zipWith(observableTwo){
//                l1, l2 -> "$l1 _ $l2"
//            }
//        ****************
//        *****************
//        val observable = Observable.range(1, 5).flatMap {
//            Observable.range(1, it)
//        }
//        val observable = Observable.create<String>{emitter ->
//            binding.etText.doOnTextChanged{text, _, _, _ ->
//                emitter.onNext(text.toString())
//            }
//        }.debounce(1, TimeUnit.SECONDS)//send search request every 1.sec
//        observable.subscribe(
//            { t -> Log.d(TAG, "foo: $t") },
//            { e -> Log.d(TAG, "foo: ${e.message}") }
//        )

        val observable = Observable.range(1, 200)
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { t -> Log.d(TAG, "foo: $t - ${Thread.currentThread().name}")},
                { e -> Log.d(TAG, "foo: ${e.message}")}
            ).add(compositeDisposable)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
    companion object {
        private const val TAG = "MainActivity"
    }
}