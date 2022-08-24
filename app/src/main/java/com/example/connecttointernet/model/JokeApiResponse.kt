package com.example.connecttointernet.model


import com.google.gson.annotations.SerializedName

data class JokeApiResponse(
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("error")
    val error: Boolean? = null,
    @SerializedName("flags")
    val flags: Flags? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("joke")
    val joke: String? = null,
    @SerializedName("lang")
    val lang: String? = null,
    @SerializedName("safe")
    val safe: Boolean? = null,
    @SerializedName("type")
    val type: String? = null
)