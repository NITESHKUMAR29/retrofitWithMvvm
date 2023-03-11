package com.example.retrofitwithmvvm

data class ApiResponseProductModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)