package com.example.connecttointernet.model

sealed class State<out T>{//generic type T used to encapsulate target data(JokeApiResponse) for generic types of data
    //out keyword used to accept all sub-classes
    data class Success<T>(val data : T) : State<T>()//if success, it will encapsulate response
    data class Failed(val error : String) : State<Nothing>()//if failed, it will encapsulate error message
    object Loading : State<Nothing>()//when loading it just loading

    fun toData() : T? = if (this is Success) data else null
    //to access data from (view) if it success
}
