package com.example.classifieds

import android.app.Application
import com.example.classifieds.data.requests.Api
import com.facebook.drawee.backends.pipeline.Fresco
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClassifiedApp() : Application() {

    var BASE_URL: String = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/"

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
    }

    fun retrofit(): Api {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: Api = retrofit.create(Api::class.java)
        return api
    }
}