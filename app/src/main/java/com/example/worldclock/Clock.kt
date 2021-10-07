package com.example.worldclock

import java.util.*

class Clock {
    private fun getCalendarInstanceById(id: String) =
        Calendar.getInstance(TimeZone.getTimeZone(id))

    private fun convertIntToAMPMString(value: Int) =
        if (value == 0) "AM" else "PM"

    private fun toTimeString(instance: Calendar, value: Int) =
        if (instance.get(value) < 9) "0${instance.get(value)}" else instance.get(value).toString()

    fun getTimeByTimeZoneId(clockLocale: ClockLocale): String {
        clockLocale.id?.let {
            val instance = getCalendarInstanceById(it)

            val hour = toTimeString(instance, Calendar.HOUR)
            val minute = toTimeString(instance, Calendar.MINUTE)
            val second = toTimeString(instance, Calendar.SECOND)
            val amPM = convertIntToAMPMString(instance.get(Calendar.AM_PM))

            return "$hour:$minute:$second $amPM"
        }
        return "Could not find time in ${clockLocale.id}"
    }

    fun getDateByTimeZoneId(clockLocale: ClockLocale): String {
        clockLocale.id?.let {
            with (getCalendarInstanceById(clockLocale.id)) {
                return "${get(Calendar.MONTH)} ${get(Calendar.DAY_OF_MONTH)}, ${get(Calendar.YEAR)}"
            }
        }
        return "Could not find date in ${clockLocale.id}"
    }
}