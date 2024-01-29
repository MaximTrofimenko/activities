package com.tmg.activities

import com.tmg.activities.integrationdb.domain.ActivityRsDto
import com.tmg.activities.integrationdb.domain.ActivityType
import com.tmg.activities.util.CaseInsensitiveFileComparator
import com.tmg.activities.util.getPrettyAvgPace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant

class ActivitiesApplicationTests {

    @Test
    fun getPrettyAvgPaceTest() {
        val pace = 489
        val prettyAvgPace = getPrettyAvgPace(pace)
        assertThat(prettyAvgPace).isEqualTo("8:09 км/ч")
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
            distance = 1000,
            totalTime = 1000,
            avgSpeed = "46",
            date = Instant.now(),
            type = ActivityType.SKI_CLASSIC,
            id = null
        )

        val compare = CaseInsensitiveFileComparator.compare(activityRsDto1, activityRsDto2)
        println(compare)
    }
}
