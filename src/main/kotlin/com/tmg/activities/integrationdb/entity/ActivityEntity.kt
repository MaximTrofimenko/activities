package com.tmg.activities.integrationdb.entity

import com.tmg.activities.integrationdb.domain.ActivityType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "activities", schema = "activities")
class ActivityEntity(

    @Id
    @GeneratedValue
    var id: UUID? = null,

    @NotNull
    @Size(max = 6)
    @Column(name = "distance", nullable = false)
    var distance: Int,

    @NotNull
    @Size(max = 6)
    @Column(name = "total_time", nullable = false)
    var totalTime: Int,

    @NotNull
    @Column(name = "activity_date", nullable = false)
    var date: Instant,

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type")
    var type: ActivityType
) {
    val avgPace: Double
        get() {
            return 0.0
        }
    val avgSpeed: String
        get() {
            val number = (distance.toDouble() / totalTime.toDouble()) * 3.6
            val format = String.format("%.2f", number)
            return "$format км/ч"
        }
}