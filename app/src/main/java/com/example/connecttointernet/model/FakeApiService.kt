package com.example.connecttointernet.model

import com.example.connecttointernet.model.domain.Wisdom
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class FakeApiService {

    private val wisdomList = listOf<Wisdom>(
        Wisdom("12.2.2009", "blablablablablablabla"),
        Wisdom("12.2.2009", "fkdbfkjbkgnldf"),
        Wisdom("12.2.2009", "dfskasdlfblkasdnvn"),
        Wisdom("12.2.2009", "blablablablablablabla"),
        Wisdom("12.2.2009", "vrthnlnuiasfc"),
        Wisdom("12.2.2009", "adsfjdasfvbablabla"),
    )

    suspend fun getRandomWisdom() : Wisdom{
        delay(5000)
        return wisdomList[Random.nextInt(wisdomList.size)]
    }

    fun getRxRandomWisdom(): Single<Wisdom>{
        val wisdom = wisdomList[Random.nextInt(wisdomList.size)]
        return Single.just(wisdom).delay(5000, TimeUnit.MILLISECONDS)
    }
}