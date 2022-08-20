package com.example.connecttointernet

import android.content.SharedPreferences

open class DataStorage(private val sharedPref: SharedPreferences?) {
    open fun updateLoginState(isLogin: Boolean) {
        val editor = sharedPref?.edit()
        editor?.let {
            it.apply {
                putBoolean("isLoggedIn", isLogin)
                apply()
            }
        }
    }
}