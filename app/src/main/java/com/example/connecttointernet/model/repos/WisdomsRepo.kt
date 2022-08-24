package com.example.connecttointernet.model.repos

import com.example.connecttointernet.model.FakeApiService
import com.example.connecttointernet.model.FakeDatabaseService
import com.example.connecttointernet.model.domain.Wisdom
import kotlinx.coroutines.flow.flow

class MainRepo {

    private val fakeApiService = FakeApiService()
    private val fakeDatabaseService = FakeDatabaseService()

    suspend fun getWisdom(): Wisdom {
        return fakeApiService.getRandomWisdom()
    }

    fun getUser() = fakeDatabaseService.getUser()

    fun getRxWisdom() = fakeApiService.getRxRandomWisdom()

    fun getWisdomFlow() =
        flow<Wisdom> { emit(fakeApiService.getRandomWisdom()) }

}