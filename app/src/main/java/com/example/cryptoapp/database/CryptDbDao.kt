package com.example.cryptoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.pojo.CoinInfo
import com.example.cryptoapp.pojo.CoinPriceInfo


@Dao
interface CryptDbDao {

    @Query("Select * from CoinPriceInfo order by lastupdate")
    fun getListCoinInfo(): LiveData<List<CoinInfo>>

    @Query("select * from CoinPriceInfo where fromsymbol = :fSym limit 1")
    fun getCoinPriceInfo(fSym: String): LiveData<CoinPriceInfo>


    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = CoinPriceInfo::class)
    fun addCoinPriceInfo(coinPriceInfo: CoinPriceInfo)



}