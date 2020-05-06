package com.example.data.extentions

import androidx.lifecycle.MutableLiveData
import com.example.data.exceptions.ApiException
import com.example.utils.Error
import com.example.utils.State
import retrofit2.Response

fun <T> Response<T>.parse(basket: MutableLiveData<State>, onSuccess: (body: T) -> Unit) {

    if (this.isSuccessful && this.code() >= 200 && this.code() < 300) {
        this.body()
    } else {
        basket.postValue(
            Error(
                ApiException(
                    this.errorBody().toString()
                )
            )
        )
    }

}