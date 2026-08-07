<?php
/**
 * POST /backend/api/auth/register.php
 * Body: { "name": "Sahil", "email": "sahil@email.com", "password": "secret123" }
 */
require_once __DIR__ . '/../../config/cors.php';
require_once __DIR__ . '/../../config/database.php';

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    jsonResponse(['error' => 'Method not allowed'], 405);
}

$body = readJsonBody();
$name = trim($body['name'] ?? '');
$email = trim($body['email'] ?? '');
$password = $body['password'] ?? '';

if ($name === '' || $email === '' || strlen($password) < 6) {
    jsonResponse(['error' => 'Invalid input. Name, email, and password (6+ chars) required.'], 422);
}

try {
    $pdo = getConnection();

    // Check if email already exists
    $check = $pdo->prepare('SELECT id FROM users WHERE email = ?');
    $check->execute([$email]);
    if ($check->fetch()) {
        jsonResponse(['error' => 'Email already registered'], 409);
    }

    // password_hash() — PHP's built-in secure hashing (never store plain passwords!)
    $hash = password_hash($password, PASSWORD_BCRYPT);

    $stmt = $pdo->prepare('INSERT INTO users (name, email, password_hash) VALUES (?, ?, ?)');
    $stmt->execute([$name, $email, $hash]);

    jsonResponse([
        'success' => true,
        'user' => [
            'id' => (int) $pdo->lastInsertId(),
            'name' => $name,
            'email' => $email,
        ]
    ], 201);

} catch (PDOException $e) {
    jsonResponse(['error' => 'Database error: ' . $e->getMessage()], 500);
}
