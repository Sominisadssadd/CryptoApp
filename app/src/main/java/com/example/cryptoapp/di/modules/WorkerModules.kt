package com.example.cryptoapp.di.modules

import com.example.cryptoapp.di.WorkerKey
import com.example.cryptoapp.workers.WorkerRefreshData
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface WorkerModules {

    @WorkerKey(WorkerRefreshData::class)
    @Binds
    @IntoMap
    fun bindWorkerRefreshData(workerRefreshData: WorkerRefreshData.WorkerFactory): ChildWorkerFactory


}