package com.tmg.activities.util

import com.tmg.activities.integrationdb.domain.ActivityRsDto

fun getPrettyAvgPace(pace: Int): String {
    val minute = pace / 60
    val sec = pace % 60

    val str = StringBuilder()
    if (sec < 10) {
        str.append("0")
    }
    str.append(sec)

    return "$minute:$str мин/км"
}

//скорость в м/сек
fun getSpeed(distance: Int, time: Int): Double = distance.toDouble() / time.toDouble()

//темп сек/км
fun getPace(speed: Double): Int {
    val d = 1000 / speed
    return d.toInt()
}

fun getKindOfRun(distance: Int, time: Int): String {
    val speed = getSpeed(distance, time)
    return when (getPace(speed)) {
        in 0..330 -> "sprint"
        in 331..480 -> "run"
        in 481..700 -> "jog"
        else -> "Wrong pace"
    }
}

object CaseInsensitiveFileComparator : Comparator<ActivityRsDto> {
    override fun compare(activity1: ActivityRsDto, activity2: ActivityRsDto): Int {
        return activity1.totalTime.compareTo(activity2.totalTime)
    }
}
