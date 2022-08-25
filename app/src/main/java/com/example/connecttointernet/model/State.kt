package com.example.connecttointernet.model

sealed class State<out T>{
    //generic type T used to encapsulate target data(JokeApiResponse) for generic types of data
    //out: keyword used to make generic type covariant
    data class Success<T>(val data: T) : State<T>()
    data class Failed(val message: String): State<Nothing>()
    object Loading : State<Nothing>()

    //To access data from the xml view
    fun toData() : T? = if (this is Success) this.data else null
}
