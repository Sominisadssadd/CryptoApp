package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel
import com.example.cryptoapp.domain.CryptDbRepository

class AddCoinInfoUseCase(val repository: CryptDbRepository) {

    suspend operator fun invoke(list: List<CoinPriceInfoDbModel>) {
        repository.addCoinPriceInfoList(list)
    }
}