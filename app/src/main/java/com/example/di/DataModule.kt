package com.example.di

import com.example.data.Api
import com.example.data.ApiImpl
import org.koin.dsl.module

val dataModule = module {

    single<Api>{
        ApiImpl(get())
    }
}