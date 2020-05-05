package com.example.domain.di

import org.kodein.di.Kodein

val domainModule = Kodein.Module("DomainModule") {
    importOnce(useCaseModule)


}