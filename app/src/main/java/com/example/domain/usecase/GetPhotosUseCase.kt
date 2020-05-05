package com.example.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.domain.Load
import com.example.domain.State
import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository

class GetPhotosUseCase(val repository: PhotoRepository) {


    val data = MutableLiveData<State>()

    suspend fun getPhotos(query: String){
        data.postValue(Load())
        repository.getPhotos(query, data)
    }
}