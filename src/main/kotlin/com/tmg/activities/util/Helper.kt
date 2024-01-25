package com.tmg.activities.util

fun getPrettyAvgPace(pace: Int): String {
    val minute = pace / 60
    val sec = pace % 60

    val str = StringBuilder()
    if (sec < 10) {
        str.append("0")
    }
    str.append(sec)

    return "$minute:$str км/ч"
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
    val pace = getPace(speed)

    return if (pace <= 330) {
        "sprint"
    } else if (pace < 480) {
        "run"
    } else {
        "jog"
    }
}
