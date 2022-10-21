package com.example.classifieds.data.requests

import com.example.classifieds.data.pojos.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("dynamodb-writer")
    fun getList(): Call<ApiResponse>

    @GET("yourwebsite/{someParam}/login")

}