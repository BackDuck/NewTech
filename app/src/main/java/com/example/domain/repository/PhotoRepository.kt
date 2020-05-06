package com.example.domain.repository

import com.example.domain.entity.PhotoEntity

interface PhotoRepository {
    suspend fun getPhotos(query: String):List<PhotoEntity>
}