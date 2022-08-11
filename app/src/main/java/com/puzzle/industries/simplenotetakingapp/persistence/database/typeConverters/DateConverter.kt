package com.puzzle.industries.simplenotetakingapp.persistence.database.typeConverters

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long) : Date{
        return Date(timestamp)
    }

    @TypeConverter
    fun toTimeStamp(date: Date) : Long{
        return date.time
    }
}