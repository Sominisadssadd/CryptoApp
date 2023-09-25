package com.example.cryptoapp.data.database

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.work.WorkManager
import com.example.cryptoapp.data.CryptDataBase
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel
import com.example.cryptoapp.data.utils.convertDbCoinPriceInfoToDomainCoinPriceInfo
import com.example.cryptoapp.di.ApplicationScope
import com.example.cryptoapp.domain.CryptDbRepository
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import javax.inject.Inject

@ApplicationScope
class CryptDbRepositoryImpl @Inject constructor(
    context: Context
) : CryptDbRepository {

    private val databaseReference = CryptDataBase.getInstance(context).daoDb()

    override suspend fun addCoinPriceInfoList(list: List<CoinPriceInfoDbModel>) {
        databaseReference.addCoinPriceList(list)
    }

    override fun getSingleCoinPriceInfo(fSym: String) = MediatorLiveData<CoinPriceInfo>().apply {
        addSource(databaseReference.getCoinPriceInfo(fSym)) {
            value = convertDbCoinPriceInfoToDomainCoinPriceInfo(it)
        }
    }

    override fun getListOfCoinsFromDb() = MediatorLiveData<List<CoinPriceInfo>>().apply {
        addSource(databaseReference.getListCoinInfo()) {
            value = it.map {
                convertDbCoinPriceInfoToDomainCoinPriceInfo(it)
            }

        }
    }
}