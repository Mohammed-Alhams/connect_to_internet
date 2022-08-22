package com.example.connecttointernet.factory_method

class MobileNotificationFactory: INotificationFactory {


    override fun create(type: Int): INotification {
        return when (type) {
            SMS -> MobileSMSNotification()
            PUSH -> MobilePushNotification()
            else -> throw IllegalArgumentException("Unknown mobile notification type")
        }
    }

    companion object{
        const val SMS = 1
        const val PUSH = 2
    }

}