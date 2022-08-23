package com.example.connecttointernet.model.repos

import com.example.connecttointernet.model.FakeApiService
import com.example.connecttointernet.model.FakeDatabaseService

class MainRepo {

    private val fakeApiService = FakeApiService()
    private val fakeDatabaseService = FakeDatabaseService()

    fun getWisdom() = fakeApiService.getRandomWisdom()

    fun getUser() = fakeDatabaseService.getUser()

    fun getRxWisdom() = fakeApiService.getRxRandomWisdom()
}