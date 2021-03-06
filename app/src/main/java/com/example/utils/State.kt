package com.example.utils

import java.lang.Exception

sealed class State
data class Success<out T>(val result: T?): State()
data class Error(val error: Exception): State()
class Load(val progress: Int = 0): State()