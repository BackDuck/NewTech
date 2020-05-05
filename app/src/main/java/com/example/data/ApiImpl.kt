package com.example.data

import androidx.lifecycle.MutableLiveData
import com.example.data.extentions.parse
import com.example.domain.State
import com.example.domain.Success
import com.example.domain.entity.PhotoEntity

class ApiImpl(val requests: Requests) : Api {

    override suspend fun getPhotos(query: String, basket: MutableLiveData<State>) {
        val response = requests.getPhoto("16369336-422aeaf67644d57b76c48fee2", query)
        val photoList: MutableList<PhotoEntity> = mutableListOf()

        response.parse(basket) {
            it.hits.forEach { item ->
                photoList.add(PhotoEntity(item.tags, item.preview, item.webImage, item.largeImage))
            }
            basket.postValue(Success(photoList))
        }


    }
}


