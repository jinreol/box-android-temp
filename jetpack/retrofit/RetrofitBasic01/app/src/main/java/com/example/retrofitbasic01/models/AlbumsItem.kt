package com.example.retrofitbasic01.models

import com.google.gson.annotations.SerializedName

data class AlbumsItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int
)