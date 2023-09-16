package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptDbRepository


class GetListOfCoinsDbUseCase(val repository: CryptDbRepository) {

    operator fun invoke() = repository.getListOfCoinsFromDb()
}