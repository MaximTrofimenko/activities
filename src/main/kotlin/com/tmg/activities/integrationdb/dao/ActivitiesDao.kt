package com.tmg.activities.integrationdb.dao

import com.tmg.activities.integrationdb.entity.ActivityEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ActivitiesDao : JpaRepository<ActivityEntity, UUID>