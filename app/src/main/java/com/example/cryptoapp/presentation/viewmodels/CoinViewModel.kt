package com.example.cryptoapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import androidx.work.Worker
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl

import com.example.cryptoapp.domain.CryptDbRepository
import com.example.cryptoapp.domain.usecases.AddCoinInfoUseCase
import com.example.cryptoapp.domain.usecases.GetCoinListApiUseCase
import com.example.cryptoapp.domain.usecases.GetListOfCoinsDbUseCase
import com.example.cryptoapp.workers.WorkerRefreshData
import com.example.cryptoapp.workers.WorkerRefreshData.Companion.WORKER_NAME
import com.example.cryptoapp.workers.WorkerRefreshData.Companion.getWorkRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject




class CoinViewModel @Inject constructor(
    application: Application,
    useCaseGetListOfCoinsInfoDb: GetListOfCoinsDbUseCase
) : AndroidViewModel(application) {


    val listOfCoinInfo = useCaseGetListOfCoinsInfoDb()


    init {
        loadData()
    }

    private fun loadData() {
        val worker = WorkManager.getInstance(getApplication())
        worker.enqueueUniqueWork(
            WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            getWorkRequest()
        )

    }

    companion object {
        const val MAIN_CURRENCY = "USD"
    }


}