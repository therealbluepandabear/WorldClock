package com.example.worldclock

data class ClockLocale(val id: String) {
    companion object {
        val US_SAMOA = ClockLocale("US/Samoa")
        val US_PACIFICNEW = ClockLocale("US/Pacific-New")
        val US_PACIFIC = ClockLocale("US/Pacific")
        val US_MOUNTAIN = ClockLocale("US/Mountain")
        val US_MICHIGAN = ClockLocale("US/Michigan")
        val US_INDIANASTARKE = ClockLocale("US/Indiana-Starke")
    }
}