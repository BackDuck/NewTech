package com.example

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class App: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@App))
        import(dataModule)
        import(domainModule)
    }
}