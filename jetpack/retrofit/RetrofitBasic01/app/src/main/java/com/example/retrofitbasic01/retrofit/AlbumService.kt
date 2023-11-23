package com.example.retrofitbasic01.retrofit

import com.example.retrofitbasic01.models.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>
}