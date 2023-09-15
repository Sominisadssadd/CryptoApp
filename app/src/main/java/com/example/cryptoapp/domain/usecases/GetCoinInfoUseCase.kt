package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptAppRepository

class GetCoinInfoUseCase(val repository: CryptAppRepository) {

    operator fun invoke(idOfCoin: Int) = repository.getCoinInfo(idOfCoin)
}