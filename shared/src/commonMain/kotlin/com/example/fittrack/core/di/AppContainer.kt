package com.example.fittrack.core.di

import com.example.fittrack.data.repository.AuthRepositoryImpl
import com.example.fittrack.data.repository.WorkoutRepositoryImpl
import com.example.fittrack.domain.repository.AuthRepository
import com.example.fittrack.domain.repository.WorkoutRepository

/**
 * Simple service locator — no DI library needed yet.
 * One place to swap fake repos for real API repos later.
 */
object AppContainer {
    val authRepository: AuthRepository = AuthRepositoryImpl()
    val workoutRepository: WorkoutRepository = WorkoutRepositoryImpl()
}
