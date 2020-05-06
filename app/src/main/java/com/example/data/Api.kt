package com.example.data

import com.example.data.pojo.response.photo.PhotoBody

interface Api{
    suspend fun getPhotos(query: String): PhotoBody
}