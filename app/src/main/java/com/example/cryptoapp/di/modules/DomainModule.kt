package com.example.cryptoapp.di.modules

import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.di.ApplicationScope
import com.example.cryptoapp.domain.CryptApiRepository
import com.example.cryptoapp.domain.CryptDbRepository
import com.example.cryptoapp.domain.usecases.GetCoinInfoDbUseCase
import com.example.cryptoapp.domain.usecases.GetListOfCoinsDbUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DomainModule {




    //Исправить ошибку, dagger тварь не знает как надо в usecase сувать реализацию интерфейса!
    @Provides
    fun bindGetListOfCoinsDbUseCase(
        repository: CryptDbRepository
    ): GetListOfCoinsDbUseCase {
        return GetListOfCoinsDbUseCase(repository)
    }

    @Provides
    fun bindGetCoinInfoUseCase(
        repository: CryptDbRepository
    ): GetCoinInfoDbUseCase {
        return GetCoinInfoDbUseCase(repository)
    }

}