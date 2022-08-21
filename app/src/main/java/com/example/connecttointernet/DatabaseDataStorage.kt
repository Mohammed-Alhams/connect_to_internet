package com.example.connecttointernet

class DatabaseDataStorage(private val databaseManager: DatabaseManager): IDataStorage{
    override fun updateLoginState(isLogin: Boolean) {
        databaseManager.insertLoginStatus(isLogin)
    }
}