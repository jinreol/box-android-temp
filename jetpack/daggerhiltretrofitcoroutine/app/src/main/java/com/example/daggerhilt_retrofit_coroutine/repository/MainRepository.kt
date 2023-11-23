package com.example.daggerhilt_retrofit_coroutine.repository

import com.example.daggerhilt_retrofit_coroutine.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getEmployee() = apiHelper.getEmployees()
}
