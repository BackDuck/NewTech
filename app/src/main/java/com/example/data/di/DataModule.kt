package com.example.data.di

import com.example.data.Api
import com.example.data.ApiImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val dataModule = Kodein.Module("DataModule") {
    importOnce(repositoryModule)
    importOnce(retrofitModule)

    bind<Api>() with singleton {
        ApiImpl(instance())
    }
}