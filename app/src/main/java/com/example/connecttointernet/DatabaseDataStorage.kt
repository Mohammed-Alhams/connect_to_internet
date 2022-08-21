package com.example.connecttointernet

class DatabaseDataStorage(private val databaseManager: DatabaseManager): IStatusSaver{
    private fun updateLoginState(isLogin: Boolean) {
        databaseManager.insertLoginStatus(isLogin)
    }

    override fun saveStatus(status: Boolean) {
        updateLoginState(status)
    }
}