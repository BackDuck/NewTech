package com.example.data

import androidx.lifecycle.MutableLiveData
import com.example.domain.State
import com.example.domain.entity.PhotoEntity

interface Api{
    suspend fun getPhotos(query: String, basket: MutableLiveData<State>)
}