package com.example.connecttointernet

class Authenticator(
    private val networking: Networking,
    private val dataStorage: IDataStorage
) {
    fun loginWithUsernameAndPassword(username: String, password: String) {
        val loginStatus = networking.makeLoginRequest(username, password)
        dataStorage.updateLoginState(loginStatus)
    }
}