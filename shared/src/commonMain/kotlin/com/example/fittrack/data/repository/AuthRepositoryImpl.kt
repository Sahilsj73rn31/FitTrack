package com.example.fittrack.data.repository

import com.example.fittrack.domain.model.User
import com.example.fittrack.domain.repository.AuthRepository

/**
 * Fake auth repo — returns mock data until PHP API is wired up (Week 2).
 * Replace calls inside with HTTP requests to backend/api/auth/*.php
 */
class AuthRepositoryImpl : AuthRepository {

    private var currentUser: User? = null

    override suspend fun login(email: String, password: String): Result<User> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(IllegalArgumentException("Email and password required"))
        }
        val user = User(
            id = 1,
            name = "FitTracker",
            email = email,
            totalDistanceKm = 31.2,
            weeklyRank = 3
        )
        currentUser = user
        return Result.success(user)
    }

    override suspend fun register(name: String, email: String, password: String): Result<User> {
        if (name.isBlank() || email.isBlank() || password.length < 6) {
            return Result.failure(IllegalArgumentException("Invalid registration data"))
        }
        val user = User(id = 1, name = name, email = email)
        currentUser = user
        return Result.success(user)
    }

    override suspend fun logout() {
        currentUser = null
    }

    fun getCurrentUser(): User? = currentUser
}
