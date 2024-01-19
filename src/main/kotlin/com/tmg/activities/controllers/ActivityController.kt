package com.tmg.activities.controllers

import com.tmg.activities.integrationdb.dao.ActivitiesDao
import com.tmg.activities.integrationdb.domain.Activity
import com.tmg.activities.integrationdb.domain.ActivityType
import com.tmg.activities.integrationdb.entity.ActivityEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("activities")
class ActivityController(private val dao: ActivitiesDao) {

    @GetMapping
    fun getAll(): List<Activity> {

        val activityEntity = ActivityEntity(null, 7370, 3671, Instant.now(), ActivityType.RUN)
        val activityEntity2 = ActivityEntity(null, 6900, 3670, Instant.now(), ActivityType.SKI_CLASSIC)

        dao.save(activityEntity)
        dao.save(activityEntity2)

        val entities = dao.findAll()

        return entities.stream()
            .map { entityToDtoConverter(it) }
            .toList()
    }

    fun entityToDtoConverter(entity: ActivityEntity): Activity = Activity(
        entity.id,
        entity.distance,
        entity.totalTime,
        entity.avgPace,
        entity.avgSpeed,
        entity.date,
        entity.type
    )
}