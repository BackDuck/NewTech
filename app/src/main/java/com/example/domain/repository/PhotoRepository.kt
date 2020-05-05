package com.example.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.domain.State
import com.example.domain.entity.PhotoEntity

interface PhotoRepository {
    suspend fun getPhotos(query: String, basket: MutableLiveData<State>)
}