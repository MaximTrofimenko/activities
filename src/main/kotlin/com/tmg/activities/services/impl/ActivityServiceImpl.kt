package com.tmg.activities.services.impl

import com.tmg.activities.exceptions.NotFoundException
import com.tmg.activities.integrationdb.converters.toEntity
import com.tmg.activities.integrationdb.converters.toRsDto
import com.tmg.activities.integrationdb.dao.ActivitiesDao
import com.tmg.activities.integrationdb.domain.ActivityRqDto
import com.tmg.activities.integrationdb.domain.ActivityRsDto
import com.tmg.activities.integrationdb.domain.ActivityType
import com.tmg.activities.services.ActivityService
import com.tmg.activities.util.LoggerMain
import com.tmg.activities.util.getKindOfRun
import com.tmg.activities.util.getPace
import com.tmg.activities.util.getPrettyAvgPace
import com.tmg.activities.util.getSpeed
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ActivityServiceImpl(private val dao: ActivitiesDao) : ActivityService {

    private val log by LoggerMain()

    override fun getAll(): List<ActivityRsDto> {
        val activities = dao.findAll().stream()
            .map { it.toRsDto() }
            .toList()
        log.info("Всего найдено ${activities.size} активностей")
        return activities
    }

    override fun addActivity(activity: ActivityRqDto): ActivityRsDto {
        val savedActivity = dao.save(activity.toEntity())
        return savedActivity.toRsDto()
    }

    override fun deleteActivity(id: UUID) {
        dao.deleteById(id)
    }

    override fun getById(id: UUID): ActivityRsDto {
        val activity = dao.findById(id)
            .map { it.toRsDto() }
            .orElseThrow<NotFoundException> {
                val message = "Не найден в базе объект с id = $id"
                log.error(message)
                throw NotFoundException(message)
            }

        val speed = getSpeed(activity.distance, activity.totalTime)
        val pace = getPace(speed)
        val prettyAvgPace = getPrettyAvgPace(pace)
        activity.avgPace = prettyAvgPace

        if (activity.type == ActivityType.RUN) {
            val kindOfRun = getKindOfRun(activity.distance, activity.totalTime)
            activity.kindOfRun = kindOfRun
        }

        return activity
    }
}
