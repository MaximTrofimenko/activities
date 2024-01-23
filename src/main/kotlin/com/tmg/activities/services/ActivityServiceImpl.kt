package com.tmg.activities.services

import com.tmg.activities.exceptions.NotFoundException
import com.tmg.activities.integrationdb.dao.ActivitiesDao
import com.tmg.activities.integrationdb.domain.Activity
import com.tmg.activities.integrationdb.entity.ActivityEntity
import com.tmg.activities.services.impl.ActivityService
import com.tmg.activities.util.LoggerMain
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ActivityServiceImpl(private val dao: ActivitiesDao) : ActivityService {

    private val log by LoggerMain()

    override fun getAll(): List<Activity> {
        return dao.findAll().stream()
            .map { entityToDtoConverter(it) }
            .toList()
    }

    override fun addActivity(activity: Activity): Activity {
        val savedActivity = dao.save(dtoToEntityConverter(activity))
        return entityToDtoConverter(savedActivity)
    }

    override fun deleteActivity(id: UUID) {
        dao.deleteById(id)
    }

    override fun getById(id: UUID): Activity {
        return dao.findById(id)
            .map { entityToDtoConverter(it) }
            .orElseThrow<NotFoundException> {
                val message = "Не найден в базе объект с id = $id"
                log.error(message)
                throw NotFoundException(message)
            }
    }
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

fun dtoToEntityConverter(activity: Activity): ActivityEntity = ActivityEntity(
    null,
    activity.distance,
    activity.totalTime,
    activity.date,
    activity.type
)
