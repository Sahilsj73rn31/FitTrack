package com.example.fittrack.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fittrack.core.di.AppContainer
import com.example.fittrack.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val workoutRepository: WorkoutRepository = AppContainer.workoutRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    fun loadHomeData(userId: Int = 1) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val stats = workoutRepository.getWeeklyStats(userId)
                val workouts = workoutRepository.getRecentWorkouts(userId)
                val leaderboard = workoutRepository.getLeaderboard()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        userName = "FitTracker",
                        weeklyStats = stats,
                        recentWorkouts = workouts,
                        leaderboard = leaderboard
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
