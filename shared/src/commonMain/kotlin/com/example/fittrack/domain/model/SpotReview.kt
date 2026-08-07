package com.example.fittrack.domain.model

data class SpotReview(
    val id: Int,
    val userId: Int,
    val workoutId: Int,
    val latitude: Double,
    val longitude: Double,
    val spotName: String,
    val rating: Int,
    val comment: String,
    val createdAt: String
)
