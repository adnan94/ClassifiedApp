package com.example.classifieds.presenter

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object{
        fun convertToDate(dateStr:String): Date {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            try {
                val date: Date = format.parse(dateStr)
                return date
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return Date()
        }
}
}