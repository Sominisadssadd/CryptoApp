package com.example.cryptoapp.domain.pojo

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class CoinPriceInfo(

    val type: String?,

    val market: String?,

    val fromsymbol: String,

    val tosymbol: String?,

    val flags: String?,

    val price: Double?,

    val lastupdate: String?,

    val median: Int?,

    val lastvolume: Double?,

    val lastvolumeto: Double?,

    val lasttradeid: String?,

    val volumeday: Double?,

    val volumedayto: Double?,

    val volume24hour: Double?,

    val volume24hourto: Double?,

    val openday: Double?,

    val highday: Double?,

    val lowday: Double?,

    val open24hour: Double?,

    val high24hour: Double?,

    val low24hour: Double?,

    val lastmarket: String?,

    val volumehour: Double?,

    val volumehourto: Double?,

    val openhour: Double?,

    val highhour: Double?,

    val lowhour: Double?,

    val toptiervolume24hour: Double?,

    val toptiervolume24hourto: Double?,

    val change24hour: Double?,

    val changepct24hour: Double?,

    val changeday: Double?,

    val changepctday: Double?,

    val changehour: Double?,

    val changepcthour: Double?,

    val conversiontype: String?,

    val conversionsymbol: String?,

    val conversionlastupdate: Int?,

    val imageurl: String?,
): Serializable