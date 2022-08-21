package com.example.connecttointernet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.connecttointernet.databinding.ActivityMainBinding
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Authenticator(
            Networking(OkHttpClient()),
          //DatabaseDataStorage(DatabaseManager())
            //or
            SharedPrefDataStorage(getSharedPreferences("m", MODE_PRIVATE))
        ).loginWithUsernameAndPassword("Mohammed", "mmhhoo")

    }
}