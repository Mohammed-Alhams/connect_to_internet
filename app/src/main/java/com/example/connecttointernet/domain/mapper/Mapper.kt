package com.example.connecttointernet.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}