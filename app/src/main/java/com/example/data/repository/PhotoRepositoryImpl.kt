package com.example.data.repository

import com.example.data.Api
import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository

class PhotoRepositoryImpl(val api: Api) : PhotoRepository{
    override suspend fun getPhotos(query: String):List<PhotoEntity>{
       return  api.getPhotos(query).hits.map {
           PhotoEntity(it.tags, it.preview, it.webImage, it.largeImage)
       }
    }

}