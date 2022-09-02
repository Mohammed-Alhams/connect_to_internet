package com.example.connecttointernet.data.remote.response


import com.google.gson.annotations.SerializedName

data class PopularResponse<T>(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val movieDtos: List<T>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)