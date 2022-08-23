package com.example.connecttointernet.model

import com.example.connecttointernet.model.domain.User

class FakeDatabaseService {

    private val user: User = User("mohmmaed")

    fun getUser() = user
}