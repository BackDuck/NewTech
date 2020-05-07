package com.example.presentation.ui.main

import androidx.lifecycle.*
import com.example.domain.usecase.GetPhotosUseCase
import com.example.presentation.ui.base.BaseViewModel
import com.example.utils.Error
import com.example.utils.Load
import com.example.utils.State
import com.example.utils.Success
import com.example.utils.secure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TestViewModel(val getPhotoUseCase: GetPhotosUseCase) : BaseViewModel() {

    val data = MutableLiveData<State>()

    fun requestChanged(query: String): MutableLiveData<State> {
        launch {
            secure({
                data.postValue(Load())
                val result = withContext(Dispatchers.IO) { getPhotoUseCase.getPhotos(query) }
                data.postValue(Success(result))
            },{
                data.postValue(Error(it))
                println("error with code $it")
            })
        }
        return data
    }



}