package com.example.fittrack.domain.repository

import com.example.fittrack.domain.model.SpotReview
import com.example.fittrack.domain.model.User
import com.example.fittrack.domain.model.Workout

interface WorkoutRepository {
    suspend fun getWeeklyStats(userId: Int): WeeklyStats
    suspend fun getRecentWorkouts(userId: Int): List<Workout>
    suspend fun getLeaderboard(): List<User>
    suspend fun getSpotReviews(workoutId: Int): List<SpotReview>
}

data class WeeklyStats(
    val totalDistanceKm: Double,
    val totalCalories: Int,
    val totalDurationMinutes: Int,
    val averagePace: String,
    val workoutsCompleted: Int
)
