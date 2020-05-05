package com.example.data

import com.example.data.pojo.response.photo.PhotoBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Requests {

    @GET("api/")
    suspend fun getPhoto(@Query("key") key: String, @Query("q") query: String): Response<PhotoBody>
}