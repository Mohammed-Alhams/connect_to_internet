package com.example.connecttointernet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.connecttointernet.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        makeHttpRequest("ahmed")
        makeHttpRequest("smeath")
    }

    private fun makeHttpRequest(name: String) {
        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.nationalize.io")
            .addQueryParameter("name", name)
            .build()

        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(TAG, "onResponse: ${response.body?.string() ?: ""}")
            }

        })
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}