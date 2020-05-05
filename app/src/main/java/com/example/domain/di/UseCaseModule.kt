package com.example.domain.di

import com.example.domain.usecase.GetPhotosUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val useCaseModule = Kodein.Module("UseCaseModule"){
    bind<GetPhotosUseCase>() with singleton {
        GetPhotosUseCase(instance())
    }
}