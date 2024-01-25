package com.tmg.activities

import com.tmg.activities.util.getPrettyAvgPace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActivitiesApplicationTests {

    @Test
    fun getPrettyAvgPaceTest() {
        val pace = 489
        val prettyAvgPace = getPrettyAvgPace(pace)
        assertThat(prettyAvgPace).isEqualTo("8:09 км/ч")
    }
}
