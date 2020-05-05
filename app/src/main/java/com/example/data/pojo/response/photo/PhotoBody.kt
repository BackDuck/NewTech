package com.example.data.pojo.response.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoBody(
        @field:SerializedName("hits")
        @field:Expose
        val hits: List<PhotoItem>
)
