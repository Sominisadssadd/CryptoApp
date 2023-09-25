package com.example.cryptoapp.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val key: KClass<out ViewModel>)
