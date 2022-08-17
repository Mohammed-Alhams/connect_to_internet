package com.example.connecttointernet.data

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country_id") val countryId: String,
    val probability: Double
)
