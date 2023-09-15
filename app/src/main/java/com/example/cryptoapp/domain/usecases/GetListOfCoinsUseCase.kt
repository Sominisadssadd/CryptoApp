package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptAppRepository


class GetListOfCoinsUseCase(val repository: CryptAppRepository) {

    operator fun invoke() = repository.getListOfCoins()
}