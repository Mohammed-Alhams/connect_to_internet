package com.example.connecttointernet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.connecttointernet.builder.FoodOrder
import com.example.connecttointernet.databinding.ActivityMainBinding
import com.example.connecttointernet.factory_method.MobileNotificationFactory
import com.example.connecttointernet.factory_method.WearableNotificationFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodOrder = FoodOrder.Builder()
            .fish("")
            .fish("")
            .build()

        val wearableNotification = WearableNotificationFactory()
            .create(WearableNotificationFactory.PUSH)

        val mobilePushNotification = MobileNotificationFactory()
            .create(MobileNotificationFactory.PUSH)

    }
}