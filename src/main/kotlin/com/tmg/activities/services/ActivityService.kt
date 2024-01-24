package com.tmg.activities.services

import com.tmg.activities.integrationdb.domain.Activity
import java.util.UUID

interface ActivityService {

    fun getAll(): List<Activity>

    fun addActivity(activity: Activity): Activity

    fun deleteActivity(id: UUID)

    fun getById(id: UUID): Activity
}