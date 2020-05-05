package com.example.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.data.Api
import com.example.domain.State
import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository

class PhotoRepositoryImpl(val api: Api) : PhotoRepository{
    override suspend fun getPhotos(query: String, basket: MutableLiveData<State>) {
        api.getPhotos(query, basket)
    }

}