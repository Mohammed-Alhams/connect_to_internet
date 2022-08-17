package com.example.connecttointernet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.connecttointernet.data.NotionalResponse
import com.example.connecttointernet.databinding.ActivityMainBinding
import com.google.gson.Gson
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val logInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val client = OkHttpClient.Builder().addInterceptor(logInterceptor).build()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFetch.setOnClickListener {
            makeHttpRequest(binding.etName.text.toString())
        }
    }

    private fun makeHttpRequest(name: String) {
        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.nationalize.io")
            .addQueryParameter("name", name)
            .build()

        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
//                Log.d(TAG, "onResponse: ${response.body?.string() ?: ""}")
                response.body?.string()?.let { jsonString ->
//                    val result = JSONObject(jsonString).toNotionalResponse()
                    val result = Gson().fromJson(jsonString, NotionalResponse::class.java)
                    Log.d(TAG, "onResponse: ${result.name}")
                }
            }

        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}