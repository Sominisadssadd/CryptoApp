package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptDbRepository

class GetCoinInfoDbUseCase(val repository: CryptDbRepository) {

    operator fun invoke(fSym: String) = repository.getSingleCoinPriceInfo(fSym)
}