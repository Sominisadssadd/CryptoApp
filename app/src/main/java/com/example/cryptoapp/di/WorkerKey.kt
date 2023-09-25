package com.example.cryptoapp.di

import androidx.work.ListenableWorker
import dagger.MapKey
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val className: KClass<out ListenableWorker>)