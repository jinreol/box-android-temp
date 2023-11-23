package com.example.daggerhilt_retrofit_coroutine.api

import com.example.daggerhilt_retrofit_coroutine.models.EmployeeResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getEmployees(): Response<EmployeeResponse>
}