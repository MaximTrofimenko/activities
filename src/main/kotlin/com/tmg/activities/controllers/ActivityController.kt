package com.tmg.activities.controllers

import com.tmg.activities.integrationdb.domain.Activity
import com.tmg.activities.services.impl.ActivityService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("activities")
class ActivityController(private val activityService: ActivityService) {

    @GetMapping
    fun getAll(): List<Activity> {
        return activityService.getAll()
    }

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: UUID): ResponseEntity<Activity> {
        val activityById = activityService.getById(id)
        return ResponseEntity.ok(activityById)
    }

    @DeleteMapping("/{id}")
    fun deleteActivity(@PathVariable id: UUID): ResponseEntity<Void> {
        activityService.deleteActivity(id)
        return ResponseEntity.noContent().build()
    }

//    @PostMapping
//    fun addActivity(@RequestBody activity: Activity, response: HttpServletResponse): ResponseEntity<Void> {
//        val addActivity = activityService.addActivity(activity)
//        response.setHeader(
//            "Location", ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/activities/" + addActivity.id.toString())
//                .toUriString()
//        )
//
//        return ResponseEntity.status(HttpStatus.CREATED).build()
//    }

    @PostMapping
    fun addActivity(@RequestBody activity: Activity): ResponseEntity<UUID> {
        val addActivity = activityService.addActivity(activity)
        return ResponseEntity(addActivity.id, HttpStatus.CREATED)
    }
}