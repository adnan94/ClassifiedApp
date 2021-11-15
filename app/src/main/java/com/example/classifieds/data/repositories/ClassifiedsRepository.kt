package com.example.classifieds.data.repositories

import android.widget.Toast
import com.example.classifieds.ClassifiedApp
import com.example.classifieds.data.pojos.ApiResponse
import com.example.classifieds.presenter.listeners.OnSucessListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClassifiedsRepository() {

    fun getClassifiedList(listener: OnSucessListener){
        val call: Call<ApiResponse> = ClassifiedApp().retrofit().getList()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                listener.onSucess(response.body()?.results!!)
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(ClassifiedApp().applicationContext, t.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }
}