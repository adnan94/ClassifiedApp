package com.example.classifieds.presenter.listeners

import com.example.classifieds.data.pojos.ClassifiedItem

interface OnSucessListener {
    fun onSucess(list: List<ClassifiedItem>)
}