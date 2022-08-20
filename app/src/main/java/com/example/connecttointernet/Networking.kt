package com.example.connecttointernet

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class Networking(private val client: OkHttpClient) {
    fun makeLoginRequest(username: String, password: String): Boolean {
        val loginRequestBody = FormBody.Builder()
            .add("username", username)
            .add("password", password)
            .build()

        val loginRequest = Request.Builder()
            .url("https://fakeapiurl.com/api/login")
            .post(loginRequestBody)
            .build()

        val response = client.newCall(loginRequest).execute()
        return response.isSuccessful
    }
}