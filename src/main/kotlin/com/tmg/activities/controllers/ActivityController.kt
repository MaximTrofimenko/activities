package com.tmg.activities.controllers

import com.tmg.activities.integrationdb.domain.Activity
import com.tmg.activities.integrationdb.domain.ActivityType
import com.tmg.activities.integrationdb.entity.ActivityEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.UUID

@RestController
@RequestMapping("activities")
class ActivityController {

    @GetMapping
    fun getAll(): List<Activity> {
        val activityEntity = ActivityEntity(UUID.randomUUID(), 7.37, 3671, Instant.now(), ActivityType.RUN)

        val activity = Activity(
            UUID.randomUUID(),
            activityEntity.distance,
            activityEntity.time,
            activityEntity.avgPace,
            activityEntity.avgSpeed,
            Instant.now(),
            ActivityType.RUN
        )

        return listOf(activity)
    }

}