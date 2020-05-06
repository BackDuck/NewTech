package com.example.utils

import retrofit2.HttpException

inline fun secure(function: () -> Unit, errorAction: ((e: HttpException) -> Unit)){
  try {
      function()
  }
  catch (e: HttpException){
      e.printStackTrace()
      errorAction(e)
  }
}

inline fun secure(function: () -> Unit){
    try {
        function()
    }
    catch (e: HttpException){
        e.printStackTrace()
    }
}