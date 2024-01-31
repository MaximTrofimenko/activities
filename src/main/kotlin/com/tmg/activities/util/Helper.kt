package com.tmg.activities.util

import com.tmg.activities.integrationdb.domain.ActivityRsDto

/**
 * Функция with возвращает результат выполнения лямбда-выражения - результат последнего выражения в теле лямбда-функции.
 * Результатом вызова - результат выполнения лямбда-выражения.
 */
fun getPrettyAvgPace(pace: Int): String {
    val minute = pace / 60
    val sec = pace % 60

    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        if (sec < 10) {
            stringBuilder.append("0")
        }
        stringBuilder.append(sec)
        "$minute:$stringBuilder мин/км"
    }
}

/**
 * Более полное использование специальной функции with.
 * Слово this. можно опустить
 */
fun getPrettyAvgPace2(pace: Int) = with(StringBuilder()) {
    val minute = pace / 60
    val sec = pace % 60
    if (sec < 10) {
        this.append("0")
    }
    this.append(sec)
    "$minute:$this мин/км"
}

/**
 * Отличный пример StringBuilder в котлиновском варианте
 */
fun alphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
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
