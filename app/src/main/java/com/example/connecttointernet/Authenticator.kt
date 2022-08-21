package com.example.connecttointernet

class Authenticator(
    //1- high level module should NOT depend on low level module, both should depend on abstraction
    private val networking: Networking,
    private val statusSaver: IStatusSaver
): ISocialLogin, IAppleLogin {
    fun loginWithUsernameAndPassword(username: String, password: String) {
        val loginStatus = networking.makeLoginRequest(username, password)
        statusSaver.saveStatus(loginStatus)
        //Now, Authenticator class doesn't depend on the tool used to
        // save the status(preference manager or DB)
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