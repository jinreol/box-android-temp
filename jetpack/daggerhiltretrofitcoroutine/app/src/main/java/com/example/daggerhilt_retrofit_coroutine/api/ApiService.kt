package com.example.daggerhilt_retrofit_coroutine.api

import com.example.daggerhilt_retrofit_coroutine.models.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("employees")
    suspend fun getEmployees(): Response<EmployeeResponse>
}