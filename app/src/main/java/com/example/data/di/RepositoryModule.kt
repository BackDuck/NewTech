package com.example.data.di

import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val repositoryModule = Kodein.Module("RepositoryModule"){
    bind<PhotoRepository>() with singleton {
        PhotoRepositoryImpl(instance())
    }
}