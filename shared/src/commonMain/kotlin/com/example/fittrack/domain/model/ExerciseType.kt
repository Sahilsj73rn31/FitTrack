package com.example.fittrack.domain.model

enum class ExerciseType(val label: String, val unit: String) {
    RUNNING("Running", "km"),
    WALKING("Walking", "km"),
    CYCLING("Cycling", "km"),
    HIKING("Hiking", "km"),
    SWIMMING("Swimming", "m"),
    GYM("Gym", "min")
}
