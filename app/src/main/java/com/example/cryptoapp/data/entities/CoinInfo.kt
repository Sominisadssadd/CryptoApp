package com.example.cryptoapp.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    )