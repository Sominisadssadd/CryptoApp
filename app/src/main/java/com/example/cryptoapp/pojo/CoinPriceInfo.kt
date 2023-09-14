package com.example.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.utils.convertLongDataToNormalTime
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity(tableName = "CoinPriceInfo")
data class CoinPriceInfo(


    @SerializedName("TYPE")
    @Expose
    val type: String?,

    @SerializedName("MARKET")
    @Expose
    val market: String?,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromsymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val tosymbol: String?,

    @SerializedName("FLAGS")
    @Expose
    val flags: String?,

    @SerializedName("PRICE")
    @Expose
    val price: Double?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastupdate: Int?,

    @SerializedName("MEDIAN")
    @Expose
    val median: Int?,

    @SerializedName("LASTVOLUME")
    @Expose
    val lastvolume: Double?,

    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastvolumeto: Double?,

    @SerializedName("LASTTRADEID")
    @Expose
    val lasttradeid: String?,

    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeday: Double?,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumedayto: Double?,

    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24hour: Double?,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24hourto: Double?,

    @SerializedName("OPENDAY")
    @Expose
    val openday: Double?,

    @SerializedName("HIGHDAY")
    @Expose
    val highday: Double?,

    @SerializedName("LOWDAY")
    @Expose
    val lowday: Double?,

    @SerializedName("OPEN24HOUR")
    @Expose
    val open24hour: Double?,

    @SerializedName("HIGH24HOUR")
    @Expose
    val high24hour: Double?,

    @SerializedName("LOW24HOUR")
    @Expose
    val low24hour: Double?,

    @SerializedName("LASTMARKET")
    @Expose
    val lastmarket: String?,

    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumehour: Double?,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    val volumehourto: Double?,

    @SerializedName("OPENHOUR")
    @Expose
    val openhour: Double?,

    @SerializedName("HIGHHOUR")
    @Expose
    val highhour: Double?,

    @SerializedName("LOWHOUR")
    @Expose
    val lowhour: Double?,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val toptiervolume24hour: Double?,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val toptiervolume24hourto: Double?,

    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24hour: Double?,

    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    val changepct24hour: Double?,

    @SerializedName("CHANGEDAY")
    @Expose
    val changeday: Double?,

    @SerializedName("CHANGEPCTDAY")
    @Expose
    val changepctday: Double?,

    @SerializedName("CHANGEHOUR")
    @Expose
    val changehour: Double?,

    @SerializedName("CHANGEPCTHOUR")
    @Expose
    val changepcthour: Double?,

    @SerializedName("CONVERSIONTYPE")
    @Expose
    val conversiontype: String?,

    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    val conversionsymbol: String?,

    @SerializedName("CONVERSIONLASTUPDATE")
    @Expose
    val conversionlastupdate: Int?,

    @SerializedName("IMAGEURL")
    @Expose
    val imageurl: String?,
) {

    fun getConvertedTime(): String {
        return convertLongDataToNormalTime(lastupdate?.toLong())
    }

    fun getFullImagePath(): String {
        return BASE_IMAGE_URL + imageurl
    }
}