package com.example.fittrack.data.repository

import com.example.fittrack.domain.model.ExerciseType
import com.example.fittrack.domain.model.SpotReview
import com.example.fittrack.domain.model.User
import com.example.fittrack.domain.model.Workout
import com.example.fittrack.domain.repository.WeeklyStats
import com.example.fittrack.domain.repository.WorkoutRepository

/**
 * Fake workout repo — mock data for UI development.
 * Week 2: replace with Ktor/fetch calls to backend/api/workouts/*.php
 */
class WorkoutRepositoryImpl : WorkoutRepository {

    override suspend fun getWeeklyStats(userId: Int): WeeklyStats = WeeklyStats(
        totalDistanceKm = 31.2,
        totalCalories = 1840,
        totalDurationMinutes = 245,
        averagePace = "5'24\"",
        workoutsCompleted = 5
    )

    override suspend fun getRecentWorkouts(userId: Int): List<Workout> = listOf(
        Workout(
            id = 1, userId = userId, exerciseType = ExerciseType.RUNNING,
            distanceKm = 5.2, durationMinutes = 28, caloriesBurned = 320,
            averagePace = "5'23\"", startedAt = "2026-08-06T07:00:00", endedAt = "2026-08-06T07:28:00"
        ),
        Workout(
            id = 2, userId = userId, exerciseType = ExerciseType.CYCLING,
            distanceKm = 12.8, durationMinutes = 45, caloriesBurned = 410,
            averagePace = "3'31\"", startedAt = "2026-08-05T18:00:00", endedAt = "2026-08-05T18:45:00"
        )
    )

    override suspend fun getLeaderboard(): List<User> = listOf(
        User(id = 2, name = "Alex Rivera", totalDistanceKm = 42.3, weeklyRank = 1),
        User(id = 3, name = "Sarah Chen", totalDistanceKm = 38.5, weeklyRank = 2),
        User(id = 1, name = "You (FitTracker)", totalDistanceKm = 31.2, weeklyRank = 3),
        User(id = 4, name = "Mike Johnson", totalDistanceKm = 29.0, weeklyRank = 4),
        User(id = 5, name = "Emma Watson", totalDistanceKm = 25.7, weeklyRank = 5)
    )

    override suspend fun getSpotReviews(workoutId: Int): List<SpotReview> = listOf(
        SpotReview(
            id = 1, userId = 1, workoutId = workoutId,
            latitude = 28.6139, longitude = 77.2090,
            spotName = "Central Park Loop", rating = 5,
            comment = "Great flat track for morning runs!", createdAt = "2026-08-06"
        )
    )
}
