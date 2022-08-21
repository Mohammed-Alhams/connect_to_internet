package com.example.connecttointernet

class Authenticator(
    private val networking: Networking,
    private val dataStorage: IDataStorage
): ISocialLogin, IAppleLogin {
    fun loginWithUsernameAndPassword(username: String, password: String) {
        val loginStatus = networking.makeLoginRequest(username, password)
        dataStorage.updateLoginState(loginStatus)
    }

    override fun loginWithAppleId() {
//        TODO("do login with apple id")
    }

    override fun loginWithGoogle() {
//        TODO("do login with google account")
    }

    override fun loginWithFacebook() {
//        TODO("do login with facebook account")
    }
}