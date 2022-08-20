package com.example.connecttointernet

import android.content.SharedPreferences

class DataStorage(private val sharedPref: SharedPreferences) {
    fun updateLoginState(isLogin: Boolean){
        val editor = sharedPref.edit()
        editor.apply {
            putBoolean("isLoggedIn", isLogin)
            apply()
        }
    }
}