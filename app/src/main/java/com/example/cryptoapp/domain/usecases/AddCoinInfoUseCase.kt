package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptAppRepository
import com.example.cryptoapp.data.entities.CoinPriceInfoDbModel

class AddCoinInfoUseCase(val repository: CryptAppRepository) {

    operator fun invoke(list: List<CoinPriceInfoDbModel>) {
        repository.addListCoinInfo(list)
    }
}