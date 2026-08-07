package com.example.fittrack.presentation.viewmodel

import com.example.fittrack.domain.model.User
import com.example.fittrack.domain.model.Workout
import com.example.fittrack.domain.repository.WeeklyStats

data class HomeUiState(
    val isLoading: Boolean = true,
    val userName: String = "",
    val weeklyStats: WeeklyStats = WeeklyStats(0.0, 0, 0, "--", 0),
    val recentWorkouts: List<Workout> = emptyList(),
    val leaderboard: List<User> = emptyList(),
    val error: String? = null
)
