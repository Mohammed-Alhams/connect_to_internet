package com.example.connecttointernet.data

import com.google.gson.annotations.SerializedName

data class NotionalResponse(
    val name: String,
    @SerializedName("country") val countries: List<Country>
)
