package com.example.presentation.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class BaseActivity : AppCompatActivity(), KodeinAware{
    override val kodein by closestKodein()

    abstract val layout: Int

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        onViewPrepare()
    }

    open fun onViewPrepare(){

    }
}