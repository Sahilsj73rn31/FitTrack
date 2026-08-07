package com.example.fittrack.domain.model

data class Workout(
    val id: Int,
    val userId: Int,
    val exerciseType: ExerciseType,
    val distanceKm: Double,
    val durationMinutes: Int,
    val caloriesBurned: Int,
    val averagePace: String,
    val routePolyline: String = "",
    val startedAt: String,
    val endedAt: String
)
