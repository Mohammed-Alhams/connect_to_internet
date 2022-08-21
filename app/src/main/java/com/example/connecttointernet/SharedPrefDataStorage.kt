package com.example.connecttointernet

import android.content.SharedPreferences

class SharedPrefDataStorage(private val sharedPref: SharedPreferences?): IDataStorage {
    override fun updateLoginState(isLogin: Boolean) {
        val editor = sharedPref?.edit()
        editor?.let {
            it.apply {
                putBoolean("isLoggedIn", isLogin)
                apply()
            }
        }
    }
}