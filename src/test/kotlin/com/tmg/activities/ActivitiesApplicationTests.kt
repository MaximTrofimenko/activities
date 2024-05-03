package com.tmg.activities

import com.tmg.activities.integrationdb.domain.ActivityRsDto
import com.tmg.activities.integrationdb.domain.ActivityType
import com.tmg.activities.integrationdb.entity.ActivityEntity
import com.tmg.activities.services.impl.User
import com.tmg.activities.util.CaseInsensitiveFileComparator
import com.tmg.activities.util.alphabet
import com.tmg.activities.util.getPrettyAvgPace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.UUID

class ActivitiesApplicationTests {

    @Test
    fun getPrettyAvgPaceTest() {
        val pace = 489
        val prettyAvgPace = getPrettyAvgPace(pace)
        assertThat(prettyAvgPace).isEqualTo("8:09 мин/км")
    }

    @Test
    fun comparatorTest() {

        val activityRsDto1 = ActivityRsDto(
            distance = 1000,
            totalTime = 10000,
            avgSpeed = "46",
            date = Instant.now(),
            type = ActivityType.SKI_CLASSIC,
            id = null
        )

        val activityRsDto2 = ActivityRsDto(
            distance = 10000,
            totalTime = 1000,
            avgSpeed = "46",
            date = Instant.now(),
            type = ActivityType.SKI_CLASSIC,
            id = null
        )

        //apply можно применять только к уже созданному объекту(!), например если на нужно поменять поле
        //apply меняет УЖЕ созданный объект
        activityRsDto2.apply { kindOfRun = "asdfg" }

        val activity = ActivityEntity(
            id = UUID.randomUUID(),
            distance = 10000,
            totalTime = 1000,
            date = Instant.now(),
            type = ActivityType.SKI_CLASSIC
        ).apply { id = UUID.randomUUID() }

        val toList = listOf(1, 2, 3, 4).asSequence().map { it + 3 }.filter { it > 5 }.toList()

        val listOf = listOf(activityRsDto1, activityRsDto2)

        val filter = listOf
            .map { it.distance }
            .filter { it == 1000 }

        val compare = CaseInsensitiveFileComparator.compare(activityRsDto1, activityRsDto2)
        println(compare)

        val objects = ArrayList<Int>()
        val integers = objects.asSequence()
            .map { it + 5 }
            .filter { it > 5 }
            .toList()

        //хороший пример инициализации юзера
        val user = User(mapOf("name" to "max", "age" to 43 ))

        println(alphabet())
        println(user.map)
        println(user.age)
    }
}
