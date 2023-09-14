package com.example.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinListInfo(
    @SerializedName("Data")
    @Expose
    var data: List<Datum>?=null
)