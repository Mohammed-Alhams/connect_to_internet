package com.example.connecttointernet.data.local

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun dateToLong(date: Date) = date.time

    @TypeConverter
    fun longToDate(time: Long) = Date(time)

}