package com.example.di

import com.example.data.Api
import com.example.data.ApiImpl
import com.example.presentation.ui.main.ImagesPagerAdapter
import org.koin.dsl.module

val adapterModule = module {

    single<ImagesPagerAdapter>{
        ImagesPagerAdapter()
    }
}