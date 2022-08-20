package com.example.connecttointernet

class DatabaseDataStorage(private val databaseManager: DatabaseManager): DataStorage(null) {
    override fun updateLoginState(isLogin: Boolean) {
        databaseManager.insertLoginStatus(isLogin)
    }
}