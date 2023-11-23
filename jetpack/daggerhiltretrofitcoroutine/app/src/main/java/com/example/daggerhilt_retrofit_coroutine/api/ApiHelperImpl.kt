package com.example.daggerhilt_retrofit_coroutine.api

import com.example.daggerhilt_retrofit_coroutine.models.EmployeeResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
): ApiHelper {
    override suspend fun getEmployees(): Response<EmployeeResponse> = apiService.getEmployees()
}