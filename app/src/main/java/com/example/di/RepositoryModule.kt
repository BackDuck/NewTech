package com.example.di

import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoRepository
import org.koin.dsl.module

val repositoryModule = module{
    single<PhotoRepository>{
        PhotoRepositoryImpl(get())
    }
}