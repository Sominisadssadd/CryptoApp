package com.example.cryptoapp.pojo

import android.media.Rating
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinInfo(


    @SerializedName("Name")
    @Expose
    private val name: String? = null,

    )