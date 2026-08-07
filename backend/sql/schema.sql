-- FitTrack Database Schema
-- Run this in phpMyAdmin or MySQL CLI after creating the database

CREATE DATABASE IF NOT EXISTS fittrack CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE fittrack;

-- USERS: stores account info
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    avatar_url VARCHAR(500) DEFAULT '',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- WORKOUTS: each exercise session
CREATE TABLE workouts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    exercise_type ENUM('RUNNING','WALKING','CYCLING','HIKING','SWIMMING','GYM') NOT NULL,
    distance_km DECIMAL(8,2) DEFAULT 0,
    duration_minutes INT DEFAULT 0,
    calories_burned INT DEFAULT 0,
    average_pace VARCHAR(20) DEFAULT '',
    route_polyline TEXT,
    started_at DATETIME NOT NULL,
    ended_at DATETIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- GPS POINTS: lat/lng trail for map area covered
CREATE TABLE gps_points (
    id INT AUTO_INCREMENT PRIMARY KEY,
    workout_id INT NOT NULL,
    latitude DECIMAL(10,7) NOT NULL,
    longitude DECIMAL(10,7) NOT NULL,
    recorded_at DATETIME NOT NULL,
    FOREIGN KEY (workout_id) REFERENCES workouts(id) ON DELETE CASCADE,
    INDEX idx_workout (workout_id)
);

-- SPOT REVIEWS: user reviews for specific locations on a route
CREATE TABLE spot_reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    workout_id INT NOT NULL,
    latitude DECIMAL(10,7) NOT NULL,
    longitude DECIMAL(10,7) NOT NULL,
    spot_name VARCHAR(200) NOT NULL,
    rating TINYINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (workout_id) REFERENCES workouts(id) ON DELETE CASCADE
);

-- LEADERBOARD VIEW: weekly distance ranking
CREATE OR REPLACE VIEW weekly_leaderboard AS
SELECT
    u.id,
    u.name,
    u.email,
    COALESCE(SUM(w.distance_km), 0) AS total_distance_km,
    RANK() OVER (ORDER BY COALESCE(SUM(w.distance_km), 0) DESC) AS weekly_rank
FROM users u
LEFT JOIN workouts w ON w.user_id = u.id
    AND w.started_at >= DATE_SUB(NOW(), INTERVAL 7 DAY)
GROUP BY u.id, u.name, u.email;
