package com.tmg.activities.integrationdb.domain

import java.time.Instant
import java.util.UUID

data class ActivityRqDto(
    val distance: Int,
    val totalTime: Int,
    val date: Instant,
    val type: ActivityType
)

data class ActivityRsDto(
    val id: UUID?,
    val distance: Int,
    val totalTime: Int,
    var avgPace: String,
    val avgSpeed: Double,
    val date: Instant,
    val type: ActivityType,
    var kindOfRun: String
)