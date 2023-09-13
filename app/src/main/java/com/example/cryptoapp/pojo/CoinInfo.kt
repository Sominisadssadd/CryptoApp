package com.example.cryptoapp.pojo

import android.media.Rating
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinInfo(
    @SerializedName("Id")
    @Expose
    private val id: String? = null,

    @SerializedName("Name")
    @Expose
    private val name: String? = null,

    @SerializedName("FullName")
    @Expose
    private val fullName: String? = null,

    @SerializedName("Internal")
    @Expose
    private val internal: String? = null,

    @SerializedName("ImageUrl")
    @Expose
    private val imageUrl: String? = null,

    @SerializedName("Url")
    @Expose
    private val url: String? = null,

    @SerializedName("Algorithm")
    @Expose
    private val algorithm: String? = null,

    @SerializedName("ProofType")
    @Expose
    private val proofType: String? = null,

    @SerializedName("Rating")
    @Expose
    private val rating: Rating? = null,



    @SerializedName("Type")
    @Expose
    private val type: Int? = null)