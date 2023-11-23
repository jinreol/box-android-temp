package com.example.daggerhilt_retrofit_coroutine.models

data class EmployeeResponse (
    val data: List<Employee> ?= null,
    val status: String ?= ""
)