package com.example.connecttointernet.util

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestsInterceptor:  Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
//        req.newBuilder().header()
        return chain.proceed(req).also { Log.i(TAG, "intercept: ${it.code}") }
    }

    companion object {
        private const val TAG = "RequestsInterceptor"
    }
}