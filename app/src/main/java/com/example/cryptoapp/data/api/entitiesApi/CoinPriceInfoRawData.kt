package com.example.cryptoapp.data.api.entitiesApi

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class CoinPriceInfoRawData(
    @SerializedName("RAW")
    @Expose
    val raw: JsonObject? = null
)