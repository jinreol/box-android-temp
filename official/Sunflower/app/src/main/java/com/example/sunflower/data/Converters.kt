package com.example.sunflower.data

import androidx.room.TypeConverter
import java.util.Calendar

/**
 * Type converters to allow Room to reference complex data types.
 * Calendar <-> Long 서로 변환
 */
class Converters {
    @TypeConverter
    fun calenderToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}