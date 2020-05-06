package com.example.domain.usecase

import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository

class GetPhotosUseCase(val repository: PhotoRepository) {

    suspend fun getPhotos(query: String):List<PhotoEntity>{
        return repository.getPhotos(query)
    }
}