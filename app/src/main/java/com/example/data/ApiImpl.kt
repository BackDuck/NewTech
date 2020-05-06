package com.example.data

import com.example.data.pojo.response.photo.PhotoBody

class ApiImpl(val requests: Requests) : Api {

    override suspend fun getPhotos(query: String):PhotoBody {
        return requests.getPhoto("16369336-422aeaf67644d57b76c48fee2", query)
    }
}


