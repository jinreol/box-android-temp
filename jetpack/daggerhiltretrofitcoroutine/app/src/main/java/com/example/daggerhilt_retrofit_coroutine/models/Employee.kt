package com.example.daggerhilt_retrofit_coroutine.models

data class Employee(
    val employee_age: String ?= "",
    val employee_name: String ?= "",
    val employee_salary: String ?= "",
    val id: String ?= "",
    val profile_image: String ?= ""
)