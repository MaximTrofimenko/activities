package com.tmg.activities.services

import com.tmg.activities.integrationdb.domain.ActivityRsDto
import com.tmg.activities.integrationdb.domain.ActivityRqDto
import java.util.UUID

interface ActivityService {

    fun getAll(): List<ActivityRsDto>

    fun addActivity(activity: ActivityRqDto): ActivityRsDto

    fun deleteActivity(id: UUID)

    fun getById(id: UUID): ActivityRsDto
}