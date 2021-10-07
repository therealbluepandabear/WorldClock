package com.example.worldclock

data class ClockLocale(val id: String?, val label: String) {
    private val timeZoneList: MutableList<ClockLocale> = mutableListOf()
    init {
        register(this)
    }

    private fun register(ck: ClockLocale) {
        timeZoneList.add(ck)
    }

    companion object {
        val US_SAMOA = ClockLocale("US/Samoa", "Time in Samoa")
        val US_PACIFICNEW = ClockLocale("US/Pacific-New", "Time in US/Pacific-New")
        val US_PACIFIC = ClockLocale("US/Pacific", "Time in US/Pacific")
        val US_MOUNTAIN = ClockLocale("US/Mountain", "US Mountain Time")
        val US_MICHIGAN = ClockLocale("US/Michigan", "Time in Michigan")
        val US_INDIANASTARKE = ClockLocale("US/Indiana-Starke", "Time in Indiana-Starke")
    }
}