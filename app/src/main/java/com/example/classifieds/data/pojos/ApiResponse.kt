package com.example.classifieds.data.pojos

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("results")
    val results : List<ClassifiedItem>? = null

}