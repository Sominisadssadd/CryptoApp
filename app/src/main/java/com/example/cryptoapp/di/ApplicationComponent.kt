package com.example.cryptoapp.di

import android.app.Application
import android.content.Context
import com.example.cryptoapp.CryptApplication
import com.example.cryptoapp.di.modules.DataModule
import com.example.cryptoapp.di.modules.DomainModule
import com.example.cryptoapp.di.modules.WorkerModules
import com.example.cryptoapp.presentation.CoinListInfoActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class,DomainModule::class,WorkerModules::class])
interface ApplicationComponent {


    fun inject(activity: CoinListInfoActivity)

    fun inject(application: CryptApplication)

    fun applciationSubComp() : ApplicationSubComponent.ApplicationSubComponentFactory


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance application: Application
        ): ApplicationComponent
    }


}