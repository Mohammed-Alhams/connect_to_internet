package com.example.connecttointernet

import android.content.SharedPreferences

class SharedPrefDataStorage(private val sharedPref: SharedPreferences?): IStatusSaver {
    private fun updateLoginState(isLogin: Boolean) {
        val editor = sharedPref?.edit()
        editor?.let {
            it.apply {
                putBoolean("isLoggedIn", isLogin)
                apply()
            }
        }
    }

    override fun saveStatus(status: Boolean) {
        updateLoginState(status)
    }
}