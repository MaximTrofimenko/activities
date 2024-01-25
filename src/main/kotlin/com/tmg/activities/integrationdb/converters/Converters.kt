package com.tmg.activities.integrationdb.converters

import com.tmg.activities.integrationdb.domain.ActivityRqDto
import com.tmg.activities.integrationdb.domain.ActivityRsDto
import com.tmg.activities.integrationdb.entity.ActivityEntity

fun entityToRsDtoConverter(entity: ActivityEntity): ActivityRsDto = ActivityRsDto(
    entity.id,
    entity.distance,
    entity.totalTime,
    "avgPace",
    entity.avgSpeed,
    entity.date,
    entity.type,
    "run"
)

fun rqDtoToEntityConverter(activity: ActivityRqDto): ActivityEntity = ActivityEntity(
    null,
    activity.distance,
    activity.totalTime,
    activity.date,
    activity.type
)