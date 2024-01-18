package com.tmg.activities.integrationdb.domain

import java.time.Instant
import java.util.UUID

data class Activity(
    val id: UUID,
    val distance: Double,
    val time: Int,
    val avgPace: Double,
    val avgSpeed: Double,
    val date: Instant,
    val type: ActivityType
)