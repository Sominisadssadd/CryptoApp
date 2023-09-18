package com.example.cryptoapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel


@Dao
interface CryptDbDao {

    @Query("Select * from CoinPriceInfo order by lastupdate desc")
    fun getListCoinInfo(): LiveData<List<CoinPriceInfoDbModel>>

    @Query("select * from CoinPriceInfo where fromsymbol = :fSym limit 1")
    fun getCoinPriceInfo(fSym: String): LiveData<CoinPriceInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = CoinPriceInfoDbModel::class)
    suspend fun addCoinPriceList(coinPriceInfo: List<CoinPriceInfoDbModel>)

}