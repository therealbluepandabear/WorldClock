package com.example.worldclock

import java.util.*

class Clock {
    private fun getCalendarInstanceById(id: String): Calendar {
        return Calendar.getInstance(TimeZone.getTimeZone(id))
    }

    private fun convertIntToAMPMString(value: Int): String {
        return if (value == 0) "AM" else "PM"
    }

    fun getTimeByTimeZoneId(id: String): String {
        with (getCalendarInstanceById(id)) {
            return "${get(Calendar.HOUR)}:${get(Calendar.MINUTE)}:${get(Calendar.SECOND)} ${convertIntToAMPMString(get(Calendar.AM_PM))}"
        }
    }

    fun getDateByTimeZoneId(id: String): String {
        with (getCalendarInstanceById(id)) {
            return "${get(Calendar.MONTH)} ${get(Calendar.DAY_OF_MONTH)}, ${get(Calendar.YEAR)}"
        }
    }
}