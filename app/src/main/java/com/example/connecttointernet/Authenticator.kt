package com.example.connecttointernet

class Authenticator(
    private val networking: Networking,
    private val dataStorage: DataStorage
) {
    fun loginWithUsernameAndPassword(username: String, password: String) {
        val loginStatus = networking.makeLoginRequest(username, password)
        dataStorage.updateLoginState(loginStatus)
    }
}