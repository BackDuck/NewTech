package com.example.di

import com.example.domain.usecase.GetPhotosUseCase
import org.koin.dsl.module

val useCaseModule = module{
    single<GetPhotosUseCase>{
        GetPhotosUseCase(get())
    }
}