package com.example.connecttointernet.factory_method

class WearableNotificationFactory : INotificationFactory {

    override fun create(type: Int): INotification {
        return when (type) {
            PUSH -> WearablePushNotification()
            else -> throw IllegalArgumentException("Unknown wearable notification type")
        }
    }

    companion object {
        const val PUSH = 1
    }

}