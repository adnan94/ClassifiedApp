package com.example.classifieds.data.viewmodels

import androidx.lifecycle.ViewModel
import com.example.classifieds.data.repositories.ClassifiedsRepository
import com.example.classifieds.data.pojos.ClassifiedItem
import com.example.classifieds.presenter.listeners.OnSucessListener

class ClassifiedsViewModel : ViewModel() {

    private val repository = ClassifiedsRepository()

    fun getClassifiedList(listener: OnSucessListener) {
        repository.getClassifiedList(object : OnSucessListener {
            override fun onSucess(list: List<ClassifiedItem>) {
                listener.onSucess(list)
            }
        })

    }

}