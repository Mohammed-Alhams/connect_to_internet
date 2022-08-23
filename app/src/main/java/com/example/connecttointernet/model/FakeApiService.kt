package com.example.connecttointernet.model

import com.example.connecttointernet.model.domain.Wisdom
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

    fun getRandomWisdom() = wisdomList[Random.nextInt(wisdomList.size)]

}