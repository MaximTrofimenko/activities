package com.tmg.activities.integrationdb.entity

import com.tmg.activities.integrationdb.domain.ActivityType
import java.time.Instant
import java.util.UUID
import kotlin.math.floor

//@Entity
//@Table(name = "activities")
class ActivityEntity(

//    @Id
    var id: UUID,

    var distance: Double,

//    @NotNull
//    @Size(max = 6)
//    @Column(name = "time", length = 8, nullable = false)
    var time: Int,

//    @NotNull
//    @Column(name = "date", nullable = false)
    var date: Instant,

//    @NotBlank
//    @JdbcTypeCode(SqlTypes.JSON)
//    @Column(name = "activity_type", columnDefinition = "jsonb", nullable = false)
    var type: ActivityType
) {
    val avgPace: Double
        get() {
            return 0.0
        }
    val avgSpeed: Double
        get() {
            val d = (distance / time) * 3600
            return floor(d * 100.0) / 100.0
        }
}