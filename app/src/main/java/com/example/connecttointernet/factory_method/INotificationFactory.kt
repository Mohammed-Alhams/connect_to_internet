package com.example.connecttointernet.factory_method

interface INotificationFactory {

    fun create(type: Int): INotification

}