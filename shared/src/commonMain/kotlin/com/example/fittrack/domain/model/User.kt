package com.example.fittrack.domain.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val avatarUrl: String = "",
    val totalDistanceKm: Double = 0.0,
    val weeklyRank: Int = 0
)
