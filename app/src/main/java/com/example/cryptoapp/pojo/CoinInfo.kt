package com.example.cryptoapp.pojo

import android.media.Rating
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    )