package com.example.connecttointernet.util

import com.example.connecttointernet.data.Country
import com.example.connecttointernet.data.NotionalResponse
import org.json.JSONObject

fun JSONObject.toNotionalResponse(): NotionalResponse{
    val name = getString("name")
    val countiesListJSONObject = getJSONArray("country")
    val countriesList = mutableListOf<Country>()
    (0 until countiesListJSONObject.length()).forEach { i ->
        val countryJsonObject = countiesListJSONObject[i] as JSONObject
        val countryId = countryJsonObject.getString("country_id")
        val probability = countryJsonObject.getDouble("probability")
        countriesList.add(Country(countryId, probability))
    }
    return NotionalResponse(name, countriesList)
}