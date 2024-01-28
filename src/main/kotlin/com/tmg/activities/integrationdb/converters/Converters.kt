package com.tmg.activities.integrationdb.converters

import com.tmg.activities.integrationdb.domain.ActivityRqDto
import com.tmg.activities.integrationdb.domain.ActivityRsDto
import com.tmg.activities.integrationdb.entity.ActivityEntity

//old var
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

fun ActivityEntity.toRsDto() = ActivityRsDto(
    id = this.id,
    distance = this.distance,
    totalTime = this.totalTime,
    avgSpeed = this.avgSpeed,
    date = this.date,
    type = this.type
)


//old var
fun rqDtoToEntityConverter(activity: ActivityRqDto): ActivityEntity {
    return ActivityEntity(
        null,
        activity.distance,
        activity.totalTime,
        activity.date,
        activity.type
    )
}

fun ActivityRqDto.toEntity() = ActivityEntity(
    distance = this.distance,
    totalTime = this.totalTime,
    date = this.date,
    type = this.type
)