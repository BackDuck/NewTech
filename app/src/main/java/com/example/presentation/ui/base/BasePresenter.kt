package com.example.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.presentation.ui.main.TestViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

abstract class BasePresenter(): ViewModel(), KodeinAware {



}