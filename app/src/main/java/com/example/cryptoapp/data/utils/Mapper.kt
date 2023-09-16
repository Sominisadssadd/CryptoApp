package com.example.cryptoapp.data.utils

import com.example.cryptoapp.data.api.ApiFactory
import com.example.cryptoapp.data.api.entitiesApi.CoinPriceInfoApiModel
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


fun convertDbCoinPriceInfoToDomainCoinPriceInfo(coinPriceInfo: CoinPriceInfoDbModel): CoinPriceInfo {
    with(coinPriceInfo) {
        return CoinPriceInfo(
            type, market, fromsymbol, tosymbol, flags,
            price, convertLongDataToNormalTime(lastupdate), median, lastvolume, lastvolumeto,
            lasttradeid, volumeday, volumedayto,
            volume24hour, volume24hourto, openday, highday,
            lowday, open24hour, high24hour, low24hour, lastmarket,
            volumehour, volumehourto, openhour, highhour, lowhour, toptiervolume24hour,
            toptiervolume24hourto, change24hour, changepct24hour, changeday, changepctday,
            changehour, changepcthour, conversiontype,
            conversionsymbol,
            conversionlastupdate,
            getFullImagePath(imageurl)
        )
    }
}


fun convertListOfApiCoinInfoToDbListOfCoinInfo(listOfCoins: List<CoinPriceInfoApiModel>): List<CoinPriceInfoDbModel> {
    val listOfCoinPriceInfo = mutableListOf<CoinPriceInfoDbModel>()
    for (coininf in listOfCoins) {
        with(coininf) {
            listOfCoinPriceInfo.add(
                CoinPriceInfoDbModel(
                    type,
                    market,
                    fromsymbol,
                    tosymbol,
                    flags,
                    price,
                    convertLongDataToNormalTime(lastupdate?.toString()),
                    median,
                    lastvolume,
                    lastvolumeto,
                    lasttradeid,
                    volumeday,
                    volumedayto,
                    volume24hour,
                    volume24hourto,
                    openday,
                    highday,
                    lowday,
                    open24hour,
                    high24hour,
                    low24hour,
                    lastmarket,
                    volumehour,
                    volumehourto,
                    openhour,
                    highhour,
                    lowhour,
                    toptiervolume24hour,
                    toptiervolume24hourto,
                    change24hour,
                    changepct24hour,
                    changeday,
                    changepctday,
                    changehour,
                    changepcthour,
                    conversiontype,
                    conversionsymbol,
                    conversionlastupdate,
                    imageurl
                )
            )
        }
    }

    return listOfCoinPriceInfo.toList()
}


private fun getFullImagePath(imageUrl: String?): String {
    return ApiFactory.BASE_IMAGE_URL + imageUrl
}


fun convertLongDataToNormalTime(time: String?): String {
    time?.let {
        try {
            val stamp = Timestamp(time.toLong())
            val date = Date(stamp.time)
            val pattern = "HH:mm:ss"
            val sdf = SimpleDateFormat(pattern, Locale.getDefault())
            sdf.timeZone = TimeZone.getDefault()

            return sdf.format(date)

        } catch (e: Exception) {
            return time
        }

    }
    return ""
}

