package com.example.cryptoapp.di

import com.example.cryptoapp.di.modules.ViewModelModule
import com.example.cryptoapp.di.qualifiers.FSymQualifier
import com.example.cryptoapp.presentation.CoinListInfoActivity
import com.example.cryptoapp.presentation.CoinListInfoFragment
import com.example.cryptoapp.presentation.CoinPriceInfoFragment
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent(modules = [ViewModelModule::class])
interface ApplicationSubComponent {


    fun inject(fragment: CoinListInfoFragment)

    fun inject(fragment: CoinPriceInfoFragment)

    @Subcomponent.Factory
    interface ApplicationSubComponentFactory {

        fun create(
            @BindsInstance @FSymQualifier fSym: String
        ): ApplicationSubComponent

    }
}