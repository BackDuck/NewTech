package com.example.di

import com.example.presentation.ui.main.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        TestViewModel(get())
    }
}