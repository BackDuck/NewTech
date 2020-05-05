package com.example.data.pojo.response.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoItem(
        @field:SerializedName("tags")
        @field:Expose
        val tags: String,

        @field:SerializedName("previewURL")
        @field:Expose
        val preview: String,

        @field:SerializedName("webformatURL")
        @field:Expose
        val webImage: String,

        @field:SerializedName("largeImageURL")
        @field:Expose
        val largeImage: String
)
